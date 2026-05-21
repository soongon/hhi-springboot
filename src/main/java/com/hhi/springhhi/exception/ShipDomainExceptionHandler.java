package com.hhi.springhhi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ShipDomainExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIAE(IllegalArgumentException e) {
        Map<String, String> message = new HashMap<>();
        message.put("code", "001");
        message.put("msg", e.getMessage());
        return message;
    }

    @ExceptionHandler(HhiShipException.class)
    public Map<String, String> handleHSE(HhiShipException e) {
        Map<String, String> message = new HashMap<>();
        message.put("code", "002");
        message.put("msg", e.getMessage());
        return message;
    }
}
