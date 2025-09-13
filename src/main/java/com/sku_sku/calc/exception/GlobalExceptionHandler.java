package com.sku_sku.calc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Lion
    @ExceptionHandler(InvalidMemberUUIDException.class)
    public ResponseEntity<String> invalidMemberUUID(InvalidMemberUUIDException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("그 UUID에 해당하는 Member 없음");
    }
}
