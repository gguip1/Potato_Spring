package Potato.Potato_Spring.service;

import Potato.Potato_Spring.dto.MemberDTO;
import Potato.Potato_Spring.entity.MemberEntity;
import Potato.Potato_Spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO){
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byid = memberRepository.findByid(memberDTO.getId());

        if(byid.isPresent()){
            MemberEntity memberEntity = byid.get();
            if(memberEntity.getPassword().equals(memberDTO.getPassword())){
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }
            else{
                return null;
            }
        }else{
            return null;
        }
    }
}
