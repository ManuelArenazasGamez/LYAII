grammar T;

@header {
import java.util.ArrayList;
import java.util.List;
}

@members {
    List<Tabla> tablas = new ArrayList<Tabla>();  
    Tabla tablaActual = null;
    String databaseName = "";
    StringBuilder sqlCode = new StringBuilder();
    StringBuilder errors = new StringBuilder();
    
    // Para manejar referencias pendientes
    class Referencia {
        String campo;
        String tablaRef;
        public Referencia(String c, String t) { campo = c; tablaRef = t; }
    }
    List<Referencia> referenciasPendientes = new ArrayList<Referencia>();
    
    public void displayError(String msg) {
        errors.append(msg + "\n");
    }
    
    private String getSQLType(String tipo) {
        if(tipo.equals("letras")) return "VARCHAR(255)";
        if(tipo.equals("numeros")) return "INT";
        if(tipo.equals("fecha")) return "DATE";
        return "VARCHAR(255)";
    }
}

inicio :  creacion usar tabla+ cerrar;

creacion : CREAR nombre=ID 
    {
        databaseName = $nombre.text;
        sqlCode.append("CREATE DATABASE IF NOT EXISTS " + $nombre.text + ";\n");
    };

usar : USAR nombre=ID 
    {
        sqlCode.append("USE " + $nombre.text + ";\n");
    };

tabla : TABLA nombre=ID INICIO 
    {
        // Inicializar nueva tabla
        Tabla t = new Tabla();
        t.nombre = $nombre.text;
        tablas.add(t);
        tablaActual = t;
        referenciasPendientes.clear();
        
        // Comenzar creación de tabla SQL
        sqlCode.append("CREATE TABLE IF NOT EXISTS " + $nombre.text + " (\n");
        sqlCode.append("    id_" + $nombre.text + " INT AUTO_INCREMENT PRIMARY KEY");
    }
    campo+ 
    FIN 
    {
        // Agregar todas las columnas primero
        sqlCode.append("\n");
        
        // Luego agregar las constraints FOREIGN KEY
        for (Referencia ref : referenciasPendientes) {
            sqlCode.append(",\n    FOREIGN KEY (" + ref.campo + ") REFERENCES " + 
                         ref.tablaRef + "(id_" + ref.tablaRef + ")");
        }
        
        sqlCode.append("\n);\n\n");
    };

campo : nombreCampo=ID tipoCampo=tipo (REFERENCIA tablaRef=ID)? 
    {
        // Agregar atributo a la estructura de datos
        Atributo a = new Atributo();
        a.nombreAtributo = $nombreCampo.text;
        a.tipoAtributo = $tipoCampo.text;
        if ($REFERENCIA != null) {
            a.referencia = $tablaRef.text;
            // Registrar referencia para agregarla después
            referenciasPendientes.add(new Referencia($nombreCampo.text, $tablaRef.text));
        }
        tablaActual.atributos.add(a);
        
        // Agregar columna a la tabla SQL
        sqlCode.append(",\n    " + $nombreCampo.text + " " + getSQLType($tipoCampo.text));
    };

tipo : (NUMERICO | ALFABETICO | FECHA);

cerrar : CERRAR;

// Palabras reservadas
CERRAR     : 'cerrar';
NUMERICO   : 'numeros';
ALFABETICO : 'letras';
FECHA      : 'fecha';
TABLA      : 'tabla';
INICIO     : 'inicio';
FIN        : 'fin';
USAR       : 'usar';
CREAR      : 'crear';
REFERENCIA : 'depende_de';

ID    : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
WS    : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};