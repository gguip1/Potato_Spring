package Potato.Potato_Spring.entity;

import Potato.Potato_Spring.dto.ExhibitionDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "exhibition")
public class ExhibitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exhibition_id;

    @Column
    private String title;

    @Column
    private String img;

    @Column
    private String url;

    @Column
    private String type_;

    @Column
    private Date start_date;

    @Column
    private Date end_date;

    public static ExhibitionEntity toExhibitionEntity(ExhibitionDTO exhibitionDTO){
        ExhibitionEntity exhibitionEntity = new ExhibitionEntity();
        exhibitionEntity.setExhibition_id(exhibitionDTO.getExhibition_id());
        exhibitionEntity.setTitle(exhibitionDTO.getTitle());
        exhibitionEntity.setImg(exhibitionDTO.getImg());
        exhibitionEntity.setUrl(exhibitionDTO.getUrl());
        exhibitionEntity.setType_(exhibitionDTO.getType_());
        exhibitionEntity.setStart_date(exhibitionDTO.getStart_date());
        exhibitionEntity.setEnd_date(exhibitionDTO.getEnd_date());
        return exhibitionEntity;
    }
}
