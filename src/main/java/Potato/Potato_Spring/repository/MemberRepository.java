package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Member;
import Potato.Potato_Spring.entity.MemberEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByid(String id);
}
