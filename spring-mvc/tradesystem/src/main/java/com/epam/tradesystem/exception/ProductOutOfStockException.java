package com.epam.tradesystem.exception;

/**
 * Created by c5231481 on 4/9/18.
 */
public class ProductOutOfStockException extends RuntimeException {

    public ProductOutOfStockException() {
    }

    public ProductOutOfStockException(String message) {
        super(message);
    }

    public ProductOutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductOutOfStockException(Throwable cause) {
        super(cause);
    }

    public ProductOutOfStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
