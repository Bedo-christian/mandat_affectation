package com.mandat.affecationf.exception;

import com.mandat.affecationf.model.Errorr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<Errorr> handleMyCustomException(CustomException ex){
        Errorr errorr = new Errorr();
        errorr.setCode(ex.getCode());
        errorr.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorr, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
