package Potato.Potato_Spring.dto;

import Potato.Potato_Spring.entity.ExhibitionEntity;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExhibitionDTO {
    private Long exhibition_id;
    private String title;
    private String img;
    private String url;
    private String type_;
    private Date start_date;
    private Date end_date;

    public static ExhibitionDTO toExhibitionDTO(ExhibitionEntity exhibitionEntity){
        ExhibitionDTO exhibitionDTO = new ExhibitionDTO();
        exhibitionDTO.setExhibition_id(exhibitionEntity.getExhibition_id());
        exhibitionDTO.setTitle(exhibitionEntity.getTitle());
        exhibitionDTO.setImg(exhibitionEntity.getImg());
        exhibitionDTO.setUrl(exhibitionEntity.getUrl());
        exhibitionDTO.setType_(exhibitionEntity.getType_());
        exhibitionDTO.setStart_date(exhibitionEntity.getStart_date());
        exhibitionDTO.setEnd_date(exhibitionEntity.getEnd_date());
        return exhibitionDTO;
    }
}
