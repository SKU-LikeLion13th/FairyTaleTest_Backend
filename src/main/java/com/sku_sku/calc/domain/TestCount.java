package com.sku_sku.calc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class TestCount {

    @Id
    @GeneratedValue
    private Long id;

    private Long count = 0L;

    public void increase() {
        this.count++;
    }
}
