package Potato.Potato_Spring.service;

import Potato.Potato_Spring.dto.ExhibitionDTO;
import Potato.Potato_Spring.entity.ExhibitionEntity;
import Potato.Potato_Spring.repository.ExhibitionJPARepository;
import Potato.Potato_Spring.repository.ExhibitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExhibitionJPAService {
    private final ExhibitionJPARepository exhibitionRepository;

    public void save(ExhibitionDTO exhibitionDTO){
        ExhibitionEntity exhibitionEntity = ExhibitionEntity.toExhibitionEntity(exhibitionDTO);
        exhibitionRepository.save(exhibitionEntity);
    }
}
