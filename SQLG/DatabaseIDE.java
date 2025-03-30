import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class DatabaseIDE extends JFrame {
    private JTextArea codeArea;
    private JTextArea sqlArea;
    private JTextArea errorArea;
    private JButton compileBtn;
    private JButton executeBtn;
    private JTextField dbUrlField;
    private JTextField userField;
    private JPasswordField passField;
    
    public DatabaseIDE() {
        super("Generador de Bases de Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLayout(new BorderLayout());
        
        // Panel de conexión
        JPanel connectionPanel = new JPanel(new GridLayout(1, 4));
        connectionPanel.add(new JLabel("URL de MySQL:"));
        dbUrlField = new JTextField("jdbc:mysql://localhost:3306/");
        connectionPanel.add(dbUrlField);
        connectionPanel.add(new JLabel("Usuario:"));
        userField = new JTextField("root");
        connectionPanel.add(userField);
        connectionPanel.add(new JLabel("Contraseña:"));
        passField = new JPasswordField();
        connectionPanel.add(passField);
        
        // Áreas de texto
        codeArea = new JTextArea();
        codeArea.setBorder(BorderFactory.createTitledBorder("Especificación de BD"));
        sqlArea = new JTextArea();
        sqlArea.setBorder(BorderFactory.createTitledBorder("Código SQL Generado"));
        sqlArea.setEditable(false);
        errorArea = new JTextArea();
        errorArea.setBorder(BorderFactory.createTitledBorder("Mensajes"));
        errorArea.setEditable(false);
        
        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        // Botón Compilar (mejorado)
        compileBtn = new JButton("Compilar Especificación");
        compileBtn.setPreferredSize(new Dimension(200, 30));
        compileBtn.setFont(new Font("Arial", Font.BOLD, 12));
        compileBtn.setBackground(new Color(70, 130, 180)); // Azul acero
        compileBtn.setForeground(Color.WHITE);
        
        // Botón Ejecutar (mejorado)
        executeBtn = new JButton("Ejecutar en MySQL");
        executeBtn.setPreferredSize(new Dimension(200, 30));
        executeBtn.setFont(new Font("Arial", Font.BOLD, 12));
        executeBtn.setBackground(new Color(34, 139, 34)); // Verde forestal
        executeBtn.setForeground(Color.WHITE);
        executeBtn.setEnabled(false);
        
        // Configuración del layout
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
            new JScrollPane(codeArea), new JScrollPane(sqlArea));
        splitPane.setDividerLocation(300);
        
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
            splitPane, new JScrollPane(errorArea));
        mainSplitPane.setDividerLocation(500);
        
        // Agregar componentes
        add(connectionPanel, BorderLayout.NORTH);
        add(mainSplitPane, BorderLayout.CENTER);
        
        buttonPanel.add(compileBtn);
        buttonPanel.add(executeBtn);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Acción del botón Compilar (mejorada)
        compileBtn.addActionListener(e -> {
            compileBtn.setBackground(new Color(65, 105, 225)); // Cambio de color al presionar
            compilar();
            new Timer(300, evt -> {
                compileBtn.setBackground(new Color(70, 130, 180)); // Vuelve al color original
                ((Timer)evt.getSource()).stop();
            }).start();
        });
        
        // Acción del botón Ejecutar
        executeBtn.addActionListener(e -> ejecutarSQL());
        
        setVisible(true);
    }
    
    private void compilar() {
        errorArea.setText("");
        String input = codeArea.getText();
        
        if (input.trim().isEmpty()) {
            errorArea.setText("Error: No hay código para compilar");
            errorArea.setForeground(Color.RED);
            executeBtn.setEnabled(false);
            return;
        }
        
        try {
            // Configurar ANTLR
            TLexer lexer = new TLexer(new ANTLRStringStream(input));
            TParser parser = new TParser(new CommonTokenStream(lexer));
            
            // Ejecutar análisis
            parser.inicio();
            
            // Mostrar resultados
            sqlArea.setText(parser.sqlCode.toString());
            
            if (parser.errors.length() > 0) {
                errorArea.setText(parser.errors.toString());
                errorArea.setForeground(Color.RED);
                executeBtn.setEnabled(false);
            } else {
                errorArea.setText("✓ Compilación exitosa! Ahora puedes ejecutar el SQL");
                errorArea.setForeground(new Color(0, 100, 0)); // Verde oscuro
                executeBtn.setEnabled(true);
            }
        } catch (Exception e) {
            errorArea.setText("Error de compilación:\n" + e.getMessage());
            errorArea.setForeground(Color.RED);
            executeBtn.setEnabled(false);
        }
    }
    
    private void ejecutarSQL() {
        String url = dbUrlField.getText();
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        String sql = sqlArea.getText();
        
        if (sql.trim().isEmpty()) {
            errorArea.setText("Error: No hay código SQL para ejecutar");
            errorArea.setForeground(Color.RED);
            return;
        }
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            
            // Mostrar progreso
            errorArea.setText("Ejecutando sentencias SQL en MySQL...");
            errorArea.setForeground(Color.BLUE);
            
            // Ejecutar cada sentencia SQL separadamente
            String[] statements = sql.split(";");
            for (String statement : statements) {
                if (!statement.trim().isEmpty()) {
                    stmt.executeUpdate(statement + ";");
                }
            }
            
            errorArea.setText("✓ Base de datos creada exitosamente en MySQL!");
            errorArea.setForeground(new Color(0, 100, 0)); // Verde oscuro
        } catch (SQLException e) {
            errorArea.setText("✗ Error al ejecutar en MySQL:\n" + e.getMessage());
            errorArea.setForeground(Color.RED);
        }
    }
    
    public static void main(String[] args) {
        try {
            // Cargar driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Iniciar interfaz con mejor aspecto
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new DatabaseIDE();
            });
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, 
                "No se encontró el driver JDBC de MySQL\n" +
                "Descarga el conector desde: https://dev.mysql.com/downloads/connector/j/", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}