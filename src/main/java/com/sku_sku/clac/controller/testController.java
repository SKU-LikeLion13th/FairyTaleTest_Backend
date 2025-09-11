package com.sku_sku.clac.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("test") //삭제 예정
    public ResponseEntity<String> getMyStatus() {
        return ResponseEntity.ok("성공");
    }
}
