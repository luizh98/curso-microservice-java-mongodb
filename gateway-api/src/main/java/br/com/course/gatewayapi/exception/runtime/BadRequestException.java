package br.com.escolaconquer.edtechindicationprogramapi.exception.runtime;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }

}
