package com.atmostadam.cats.api.exception;

public class CatException extends Exception {
    public CatException() {  super(); }

    public CatException(String message) {
        super(message);
    }

    public CatException(String message, Object... args) {
        super(String.format(message, args));
    }

    public CatException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public CatException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }
}
