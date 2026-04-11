package pe.edu.idat.book_service.dto;

import java.time.LocalDateTime;

public class ErrorMessage {

	private Integer statusCode;
    private LocalDateTime dateError;
    private String message;
    private String description;

    public ErrorMessage() {}

    public ErrorMessage(Integer statusCode, LocalDateTime dateError, String message, String description) {
        this.statusCode = statusCode;
        this.dateError = dateError;
        this.message = message;
        this.description = description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getDateError() {
        return dateError;
    }

    public void setDateError(LocalDateTime dateError) {
        this.dateError = dateError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}