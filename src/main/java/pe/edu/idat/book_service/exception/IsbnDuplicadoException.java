package pe.edu.idat.book_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IsbnDuplicadoException extends RuntimeException {
    public IsbnDuplicadoException(String message) {
        super(message);
    }
}