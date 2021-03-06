package org.reqlist.arch.exception;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity notFound() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity badRequest(ConstraintViolationException exception) {
        return new ResponseEntity(exception.getConstraintViolations(), HttpStatus.BAD_REQUEST);
    }
    
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(BindException.class)
//    public ResponseEntity badRequest(BindException exception) {
//        List<ObjectError> violations = exception.getAllErrors();
//        return new ResponseEntity(violations, HttpStatus.BAD_REQUEST);
//    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity internalServerError(Throwable throwable) {
        Error error = new Error(ErrorLevel.ERROR, throwable.getLocalizedMessage());
        
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
