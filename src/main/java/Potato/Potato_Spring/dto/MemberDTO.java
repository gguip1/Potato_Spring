package Potato.Potato_Spring.dto;

import Potato.Potato_Spring.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private int index;
    private String id;
    private String password;
    private String name;
    private String birth;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setBirth(String.valueOf(memberEntity.getBirth()));
        return memberDTO;
    }
}
