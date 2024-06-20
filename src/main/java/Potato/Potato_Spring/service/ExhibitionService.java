package Potato.Potato_Spring.service;

import Potato.Potato_Spring.domain.Exhibition;
import Potato.Potato_Spring.dto.ExhibitionDTO;
import Potato.Potato_Spring.entity.ExhibitionEntity;
import Potato.Potato_Spring.entity.MemberEntity;
import Potato.Potato_Spring.repository.ExhibitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;


//    @Autowired
//    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
//        this.exhibitionRepository = exhibitionRepository;
//    }

    public List<Exhibition> getExhibition(String query) {
        return exhibitionRepository.getExhibition(query);
    }
}
