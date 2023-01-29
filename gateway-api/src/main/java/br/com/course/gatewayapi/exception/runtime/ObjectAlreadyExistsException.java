package br.com.escolaconquer.edtechindicationprogramapi.exception.runtime;

public class ObjectAlreadyExistsException extends RuntimeException {

    public ObjectAlreadyExistsException() { }

    public ObjectAlreadyExistsException(String message) {
        super(message);
    }

    public ObjectAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}