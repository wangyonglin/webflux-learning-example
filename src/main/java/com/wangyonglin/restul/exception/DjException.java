package com.wangyonglin.restful.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DjException extends RuntimeException {

    public DjException(String id) {
        super(String.format("Product with id %s not found.", id));
    }
}
