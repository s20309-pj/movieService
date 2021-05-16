package pl.edu.pjwstk.matyliano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class ResourceAlreadyExistException extends RuntimeException {

    public ResourceAlreadyExistException(final String message) {
        super(message + " already exist");
    }
}
