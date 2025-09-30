package io.universechat.app.core.exception;

public class FileContentTypeNotFoundException extends RuntimeException {

    public FileContentTypeNotFoundException() {
        super();
    }

    public FileContentTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileContentTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected FileContentTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FileContentTypeNotFoundException(String message) {
        super(message);
    }
}
