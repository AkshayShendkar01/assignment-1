package com.bnt.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

public class CustomResponseEntity extends ResponseEntity implements Serializable {


    public CustomResponseEntity(HttpStatus status) {
        super(status);
    }

    public CustomResponseEntity(Object body, HttpStatus status) {
        super(body, status);
    }

    public CustomResponseEntity(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public CustomResponseEntity(Object body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }

    public CustomResponseEntity(Object body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
