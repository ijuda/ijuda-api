package br.com.ijuda.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice(basePackages = "br.com.ijuda.api.controller")
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> userNotFound (UserNotFoundException userNotFoundException){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Usuario não encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
