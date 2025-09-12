package com.sku_sku.calc.service;

import com.sku_sku.calc.domain.Member;
import com.sku_sku.calc.dto.MemberInfoRes;
import com.sku_sku.calc.dto.ReqMemberInfo;
import com.sku_sku.calc.reposiroty.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void addMemberInfo(ReqMemberInfo reqMemberInfo) {
        Member member = new Member(reqMemberInfo.major(), reqMemberInfo.studentId(), reqMemberInfo.name());
        memberRepository.save(member);
    }

    @Transactional
    public void checkProductReceipt(String studentId) {
        Member member = memberRepository.findByStudentId(studentId);
        member.setCheck(!member.isCheck());
    }

    public MemberInfoRes searchByStudentId(String studentId) {
        Member member = memberRepository.findByStudentId(studentId);
        return new MemberInfoRes(member.getMajor(), member.getStudentId(), member.getName(), member.isCheck());
    }

    public List<MemberInfoRes> findMemberInfoAll() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberInfoRes(
                        member.getMajor(),
                        member.getStudentId(),
                        member.getName(),
                        member.isCheck()
                ))
                .toList();
    }
}
