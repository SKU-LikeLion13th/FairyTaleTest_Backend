package com.sku_sku.calc.controller;

import com.sku_sku.calc.dto.MbtiCountRes;
import com.sku_sku.calc.service.CountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/count")
public class CountController {

    private final CountService countService;

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalCount() {
        return ResponseEntity.status(HttpStatus.OK).body(countService.getTotalCount());
    }

    @GetMapping("/mbti")
    public ResponseEntity<List<MbtiCountRes>> getMbtiCount() {
        return ResponseEntity.status(HttpStatus.OK).body(countService.getMbtiCounts());
    }
}