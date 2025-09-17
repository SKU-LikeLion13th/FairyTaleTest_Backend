package com.sku_sku.calc.service;

import com.sku_sku.calc.domain.MbtiCount;
import com.sku_sku.calc.domain.TestCount;
import com.sku_sku.calc.dto.MbtiResultRes;
import com.sku_sku.calc.dto.ReqAnswer;
import com.sku_sku.calc.reposiroty.MbtiCountRepository;
import com.sku_sku.calc.reposiroty.TestCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MbtiService {

    private final TestCountRepository testCountRepository;
    private final MbtiCountRepository mbtiCountRepository;

    @Transactional
    public MbtiResultRes calculate(List<ReqAnswer> reqAnswerList) {
        int e = 0, i = 0,
                n = 0, s = 0,
                f = 0, t = 0,
                j = 0, p = 0;

        for (ReqAnswer reqAnswer : reqAnswerList) {
            switch (reqAnswer.answer()) {
                case "E" -> e++;
                case "I" -> i++;
                case "N" -> n++;
                case "S" -> s++;
                case "F" -> f++;
                case "T" -> t++;
                case "J" -> j++;
                case "P" -> p++;
            }
        }

        String mbti =
                (e >= i ? "E" : "I")
                + (n >= s ? "N" : "S")
                + (f >= t ? "F" : "T")
                + (j >= p ? "J" : "P");

        increaseTestCount(); // 테스트 참여자 수
        increaseMbtiCount(mbti); // mbti 별로 카운트

        return new MbtiResultRes(mbti);
    }

    private void increaseTestCount() {
        TestCount testCount = testCountRepository.findById(1L)
                .orElseGet(() -> testCountRepository.save(new TestCount()));
        testCount.increase();
    }

    private void increaseMbtiCount(String mbti) {
        MbtiCount mbtiCount = mbtiCountRepository.findByMbti(mbti)
                .orElseGet(() -> mbtiCountRepository.save(new MbtiCount(mbti)));
        mbtiCount.increase();
    }
}
