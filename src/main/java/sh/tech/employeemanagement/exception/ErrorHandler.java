package sh.tech.employeemanagement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;
import static sh.tech.employeemanagement.model.enums.ExceptionConstants.UNEXPECTED_EXCEPTION;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(INTERNAL_SERVER_ERROR)
//    public ErrorResponse handle(Exception ex) {
//        log.error(ex.getMessage());
//        return ErrorResponse.builder().code(UNEXPECTED_EXCEPTION.getCode()).message(UNEXPECTED_EXCEPTION.getMessage()).build();
//    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handle(NotFoundException ex) {
        log.error(ex.getMessage());
        return ErrorResponse.builder().code(ex.getCode()).message(ex.getMessage()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handle(MethodArgumentNotValidException ex){
        log.error("ValidationException ", ex);
        return new ErrorResponse(ex.getStatusCode().toString().substring(3),
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
