package br.com.course.gatewayapi.exception.runtime;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }

}
