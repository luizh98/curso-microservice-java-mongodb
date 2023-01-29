package br.com.escolaconquer.edtechindicationprogramapi.exception.runtime;

public class RequiredFieldException extends RuntimeException {
    public RequiredFieldException() {
        super();
    }

    public RequiredFieldException(String message) {
        super(message);
    }

    public RequiredFieldException(String message, Throwable cause) {
        super(message, cause);
    }

}