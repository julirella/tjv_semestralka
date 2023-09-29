package cz.cvut.fit.tjv.climbers2;

import cz.cvut.fit.tjv.climbers2.business.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//source: https://nikhilsukhani.medium.com/mastering-exception-handling-in-spring-boot-using-controlleradvice-and-exceptionhandler-e676b5dd62ed
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
