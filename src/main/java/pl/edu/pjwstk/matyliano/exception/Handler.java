package pl.edu.pjwstk.matyliano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleRuntimeException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<Object> handleRuntimeException(ResourceAlreadyExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
    }
}
