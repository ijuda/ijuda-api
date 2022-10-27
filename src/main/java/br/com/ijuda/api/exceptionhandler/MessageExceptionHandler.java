package br.com.ijuda.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class MessageExceptionHandler {

    private Date timeStamp;
    private Integer status;
    private String message;

}
