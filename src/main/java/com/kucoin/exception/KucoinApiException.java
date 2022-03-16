package com.kucoin.exception;

import com.kucoin.KucoinApiError;

/**
 * An exception which can occur while invoking methods of the Kucoin API.
 */
public class KucoinApiException extends RuntimeException {

    private static final long serialVersionUID = 8280463674117834117L;

    private KucoinApiError error;

    public KucoinApiException(KucoinApiError error) {
        this.error = error;
    }

    public KucoinApiException() {
        super();
    }

    public KucoinApiException(String message) {
        super(message);
    }

    public KucoinApiException(Throwable cause) {
        super(cause);
    }

    public KucoinApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Kucoin API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public KucoinApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
