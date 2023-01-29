package br.com.escolaconquer.edtechindicationprogramapi.exception;

import br.com.escolaconquer.edtechindicationprogramapi.exception.runtime.BadRequestException;
import br.com.escolaconquer.edtechindicationprogramapi.exception.runtime.ObjectAlreadyExistsException;
import br.com.escolaconquer.edtechindicationprogramapi.exception.runtime.ObjectNotFoundException;
import br.com.escolaconquer.edtechindicationprogramapi.exception.runtime.RequiredFieldException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionManager {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Response> badRequestException(BadRequestException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Response(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Response> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Response(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler({RequiredFieldException.class})
    public ResponseEntity<Response> requiredField(RequiredFieldException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Response(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> internalServerError(Exception e, HttpServletRequest request) {
        log.error("Exception: " + e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(
                HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Response> handleMissingParams(MissingServletRequestParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Response(HttpStatus.BAD_REQUEST,
                        (String.format("Missing parameter with name: %s", ex.getParameterName()))));
    }

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    public ResponseEntity<Response> objectAlreadyExists(ObjectAlreadyExistsException e,
                                                        HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Response(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

}
