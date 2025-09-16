package com.sku_sku.calc.service;

import com.sku_sku.calc.domain.Member;
import com.sku_sku.calc.dto.MemberInfoRes;
import com.sku_sku.calc.exception.InvalidMemberUUIDException;
import com.sku_sku.calc.reposiroty.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

//    @Transactional
//    public void addMemberInfo(ReqMemberInfo reqMemberInfo) {
//        Member member = new Member(reqMemberInfo.major(), reqMemberInfo.studentId(), reqMemberInfo.name());
//        memberRepository.save(member);
//    }

    @Transactional
    public void addMemberInfo(String memberInfo) {
        Member member = new Member(memberInfo);
        memberRepository.save(member);
    }

    @Transactional
    public void checkProductReceipt(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(InvalidMemberUUIDException::new);
        member.setCheck(!member.isCheck());
    }

    public List<MemberInfoRes> searchByMemberInfo(String memberInfo) {
        return memberRepository.findByMemberInfoContaining(memberInfo).stream()
                .map(member -> new MemberInfoRes(
                        member.getId(),
                        member.getMemberInfo(),
                        member.isCheck()
                ))
                .toList();
    }

    public List<MemberInfoRes> findMemberInfoAll() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberInfoRes(
                        member.getId(),
                        member.getMemberInfo(),
                        member.isCheck()
                ))
                .toList();
    }
}
