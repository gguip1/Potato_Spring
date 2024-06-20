package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Exhibition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExhibitionRepository {
    List<Exhibition> getExhibition(String query);
}
