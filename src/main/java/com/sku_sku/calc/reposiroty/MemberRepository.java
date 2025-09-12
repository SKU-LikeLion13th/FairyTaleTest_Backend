package com.sku_sku.calc.reposiroty;

import com.sku_sku.calc.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {

    Member findByStudentId(String studentId);
}
