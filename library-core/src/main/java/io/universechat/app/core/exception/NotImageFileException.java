package io.universechat.app.core.exception;

public class NotImageFileException extends RuntimeException {

    public NotImageFileException() {
        super();
    }

    public NotImageFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImageFileException(Throwable cause) {
        super(cause);
    }

    protected NotImageFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotImageFileException(String message) {
        super(message);
    }
}
