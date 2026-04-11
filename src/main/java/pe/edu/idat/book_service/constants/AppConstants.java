package pe.edu.idat.book_service.constants;

public final class AppConstants {
    
    private AppConstants() {
        throw new IllegalStateException("Clase de constantes - No instanciar");
    }
    
    public static final String REGEX_ISBN = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$";
    public static final String REGEX_SOLO_LETRAS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
}