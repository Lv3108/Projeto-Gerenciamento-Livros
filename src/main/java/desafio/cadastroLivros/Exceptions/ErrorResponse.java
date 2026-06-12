package desafio.cadastroLivros.Exceptions;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponse {
    private String error;
    private int numberError = 400;
    private String statusError;
    private LocalDate timestamp = LocalDate.now();

    public ErrorResponse(String error) {
        this.error = error;
        this.numberError = 400;
        this.statusError = "Bad found";
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNumberError() {
        return numberError;
    }

    public void setNumberError(int numberError) {
        this.numberError = numberError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
