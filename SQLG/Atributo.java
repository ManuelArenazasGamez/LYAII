public class Atributo {
    public String nombreAtributo;
    public String tipoAtributo;
    public String referencia;
    
    @Override
    public String toString() {
        return nombreAtributo + " (" + tipoAtributo + 
               (referencia != null ? " -> " + referencia : "") + ")";
    }
}