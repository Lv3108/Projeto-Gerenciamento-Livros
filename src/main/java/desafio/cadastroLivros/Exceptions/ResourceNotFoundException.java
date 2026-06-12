package desafio.cadastroLivros.Exceptions;


import org.springframework.data.crossstore.ChangeSetPersister;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(String message, Object ... params) {
        super(String.format(message, params));
    }
}
