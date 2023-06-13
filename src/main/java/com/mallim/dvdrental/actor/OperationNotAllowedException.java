package com.mallim.dvdrental.actor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperationNotAllowedException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 3817729211331814408L;

    public OperationNotAllowedException() {
        super();
    }

    public OperationNotAllowedException(String message) {
        super(message);
    }
}
