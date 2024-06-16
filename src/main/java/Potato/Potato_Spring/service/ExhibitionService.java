package Potato.Potato_Spring.service;

import Potato.Potato_Spring.domain.Exhibition;
import Potato.Potato_Spring.repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionService {
    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public List<Exhibition> getExhibition(String query) {
        return exhibitionRepository.getExhibition(query);
    }
}
