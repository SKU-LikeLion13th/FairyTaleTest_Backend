package com.sku_sku.calc.controller;

import com.sku_sku.calc.dto.MemberInfoRes;
import com.sku_sku.calc.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<Void> addMemberInfo(@RequestParam String memberInfo) {
        memberService.addMemberInfo(memberInfo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/check/{uuid}")
    public ResponseEntity<Void> checkProductReceipt(@PathVariable UUID uuid) {
        memberService.checkProductReceipt(uuid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<MemberInfoRes>> searchByStudentId(@RequestParam String keyword) {
        List<MemberInfoRes> result = memberService.searchByStudentId(keyword);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberInfoRes>> findMemberInfoAll() {
        List<MemberInfoRes> result = memberService.findMemberInfoAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
