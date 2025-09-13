package com.sku_sku.calc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue
    private UUID id; // pk

//    private String major; // 학과
//
//    private String studentId; // 학번
//
//    private String name; // 이름
    private String memberInfo;

    @Setter
    private boolean isCheck; // 상품 수령 여부

    public Member(String memberInfo) {
        this.memberInfo = memberInfo;
        this.isCheck = false;
    }

}
