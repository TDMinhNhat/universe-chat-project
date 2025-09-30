package io.universechat.app.core.exception;

public class CredentialMinIOException extends RuntimeException {
    public CredentialMinIOException() {
        super();
    }

    public CredentialMinIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CredentialMinIOException(Throwable cause) {
        super(cause);
    }

    protected CredentialMinIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CredentialMinIOException(String message) {
        super(message);
    }
}
