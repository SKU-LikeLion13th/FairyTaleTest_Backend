package com.sku_sku.calc.service;

import com.sku_sku.calc.domain.TestCount;
import com.sku_sku.calc.dto.MbtiCountRes;
import com.sku_sku.calc.reposiroty.MbtiCountRepository;
import com.sku_sku.calc.reposiroty.TestCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CountService {

    private final TestCountRepository testCountRepository;
    private final MbtiCountRepository mbtiCountRepository;

    public Long getTotalCount() {
        return testCountRepository.findById(1L)
                .map(TestCount::getCount)
                .orElse(0L);
    }


    public List<MbtiCountRes> getMbtiCounts() {
        return mbtiCountRepository.findAll().stream()
                .map(mbtiCount -> new MbtiCountRes(mbtiCount.getId(), mbtiCount.getMbti(), mbtiCount.getCount()))
                .toList();
    }
}
