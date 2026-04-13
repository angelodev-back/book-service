package pe.edu.idat.book_service.constants;

public final class AppConstants {
    
    private AppConstants() {
        throw new IllegalStateException("Clase de constantes - No instanciar");
    }
    
    public static final String REGEX_ISBN = "^(?:\\d{10}|\\d{13})$";
    public static final String MSG_ISBN = "El ISBN debe tener 10 o 13 dígitos numéricos";
    
    public static final int MAX_TITULO = 200;
    public static final int MIN_TITULO = 1;
    public static final String MSG_TITULO = "El título debe tener entre " + MIN_TITULO + " y " + MAX_TITULO + " caracteres";
    
    public static final String REGEX_SOLO_LETRAS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    public static final int MAX_AUTOR = 150;
    public static final int MIN_AUTOR = 2;
    public static final String MSG_AUTOR = "El autor solo debe contener letras y espacios (mínimo " + MIN_AUTOR + ", máximo " + MAX_AUTOR + " caracteres)";
    
    public static final int MAX_GENERO = 80;
    public static final int MIN_GENERO = 2;
    public static final String MSG_GENERO = "El género solo debe contener letras y espacios (mínimo " + MIN_GENERO + ", máximo " + MAX_GENERO + " caracteres)";
    
    public static final String MSG_STOCK = "El stock no puede ser negativo";
}