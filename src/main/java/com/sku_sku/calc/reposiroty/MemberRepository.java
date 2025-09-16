package com.sku_sku.calc.reposiroty;

import com.sku_sku.calc.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByMemberInfoContaining(String memberInfo);
}
