package com.API.CentroPokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LeitoServiceException extends RuntimeException {
    public LeitoServiceException() {
        super();
    }

    public LeitoServiceException(final String message) {
        super(message);
    }
    public LeitoServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
    public LeitoServiceException(final Throwable cause) {
        super(cause);
    }
}
