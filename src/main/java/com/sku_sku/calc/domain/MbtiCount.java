package com.sku_sku.calc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class MbtiCount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String mbti;

    private Long count = 0L;

    public MbtiCount(String mbti) {
        this.mbti = mbti;
        this.count = 0L;
    }

    public void increase() {
        this.count++;
    }
}
