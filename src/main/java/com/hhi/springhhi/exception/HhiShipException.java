package com.hhi.springhhi.exception;

public class HhiShipException extends RuntimeException {
    public HhiShipException(String message) {
        super(message);
    }
    public HhiShipException(String message, Throwable cause) {
        super(message, cause);
    }
    public HhiShipException(Throwable cause) {
        super(cause);
    }
}
