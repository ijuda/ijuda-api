package br.com.ijuda.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@ControllerAdvice(basePackages = "br.com.ijuda.api.controller")
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> userNotFound (UserNotFoundException userNotFoundException){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Usuario não encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionHandler> argumentsNotValid (MethodArgumentNotValidException methodArgumentNotValidException){
        BindingResult result = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();

        StringBuilder sb = new StringBuilder("Os Campos não podem ser nulos: ");
        for (FieldError fieldError: fieldErrorList) {
            sb.append(" | ");
            sb.append(" -> ");
            sb.append(fieldError.getField());
            sb.append(" <- ");
        }

        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), sb.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
