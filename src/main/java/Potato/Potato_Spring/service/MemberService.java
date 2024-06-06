package Potato.Potato_Spring.service;

import Potato.Potato_Spring.domain.Member;
import Potato.Potato_Spring.repository.JdbcMemberRepository;
import Potato.Potato_Spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int signup(Member member){

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getUserindex();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    private Optional<Member> findMember(String userid){
        return memberRepository.findById(userid);
    }
}
