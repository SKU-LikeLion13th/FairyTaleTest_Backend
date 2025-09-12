package com.sku_sku.calc.service;

import com.sku_sku.calc.dto.MbtiResultRes;
import com.sku_sku.calc.dto.ReqAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MbtiCalcService {

    @Transactional
    public MbtiResultRes calculate(List<ReqAnswer> answerList) {
        int e = 0, i = 0,
                n = 0, s = 0,
                f = 0, t = 0,
                j = 0, p = 0;
        for (ReqAnswer reqAnswer : answerList) {
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

        StringBuilder mbti = new StringBuilder();
        mbti.append(e >= i ? "E" : "I");
        mbti.append(n >= s ? "N" : "S");
        mbti.append(f >= t ? "F" : "T");
        mbti.append(j >= p ? "J" : "P");

        return new MbtiResultRes(mbti.toString());
    }

}
