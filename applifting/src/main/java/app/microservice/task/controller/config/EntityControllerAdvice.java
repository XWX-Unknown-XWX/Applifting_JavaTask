package app.microservice.task.controller.config;

import app.microservice.task.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityControllerAdvice extends ResponseEntityExceptionHandler {


    public static final String MISSING_FIELD = "MISSING_FIELD";

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> notFoundControllerException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorCode());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> missingControllerException(RuntimeException re) {
        return errorRequest(MISSING_FIELD + ": " + re.getMessage());
    }

    private ResponseEntity<Object> errorRequest(String s) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
    }
}
