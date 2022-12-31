package com.atmostadam.cats.api.exception;

public class CatRuntimeException extends RuntimeException {
    public CatRuntimeException(Throwable cause) {
        super(cause);
    }

    public CatRuntimeException(String message) {
        super(message);
    }
}
