package com.sku_sku.calc.controller;

import com.sku_sku.calc.dto.MbtiResultRes;
import com.sku_sku.calc.dto.ReqAnswer;
import com.sku_sku.calc.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mbti")
public class MbtiController {

    private final MbtiService mbtiService;

    @PostMapping("/result")
    public ResponseEntity<MbtiResultRes> calculate(@RequestBody List<ReqAnswer> reqAnswerList) {
        MbtiResultRes mbtiResultRes = mbtiService.calculate(reqAnswerList);
        return ResponseEntity.status(HttpStatus.OK).body(mbtiResultRes);
    }
}
