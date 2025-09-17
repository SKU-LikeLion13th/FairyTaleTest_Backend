package com.sku_sku.calc.reposiroty;

import com.sku_sku.calc.domain.MbtiCount;
import com.sku_sku.calc.domain.TestCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MbtiCountRepository extends JpaRepository<MbtiCount, Long> {
    Optional<MbtiCount> findByMbti(String mbti);
}
