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
    public void checkProductReceipt(UUID uuid) {
        Member member = memberRepository.findById(uuid).orElseThrow(InvalidMemberUUIDException::new);
        member.setCheck(!member.isCheck());
    }

    public List<MemberInfoRes> searchByMemberInfo(String memberInfo) {
        return memberRepository.findByMemberInfoContaining(memberInfo).stream()
                .map(dto -> new MemberInfoRes(
                        dto.getMemberInfo(),
                        dto.isCheck()
                ))
                .toList();
    }

    public List<MemberInfoRes> findMemberInfoAll() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberInfoRes(
                        member.getMemberInfo(),
                        member.isCheck()
                ))
                .toList();
    }
}
