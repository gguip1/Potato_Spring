package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findById(String userid);
}
