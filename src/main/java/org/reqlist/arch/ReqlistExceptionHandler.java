package org.reqlist.arch;

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@ControllerAdvice
public class ReqlistExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity notFound() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Set<ConstraintViolation<?>>> badRequest(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }
    
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(BindException.class)
//    public ResponseEntity badRequest(BindException exception) {
//        List<ObjectError> violations = exception.getAllErrors();
//        return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
//    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity internalServerError() {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
