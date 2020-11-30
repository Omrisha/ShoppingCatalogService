package il.ac.afeka.shoppingcatalogservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {
    private static final long serializedVersionUID = 1L;

    public InternalErrorException(String message) {
        super(message);
    }
}
