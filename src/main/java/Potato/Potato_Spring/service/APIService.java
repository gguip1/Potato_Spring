package Potato.Potato_Spring.service;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;
import Potato.Potato_Spring.domain.Genre;
import Potato.Potato_Spring.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class APIService {
    private final APIRepository APIRepository;

    @Autowired
    public APIService(APIRepository APIRepository) {
        this.APIRepository = APIRepository;
    }

    public List<Count> countAll(String tableName){
        return APIRepository.countAll(tableName);
    }
    public List<Content> findAllByPage(String tableName, int page, int pagingUnit){
        return APIRepository.findAllByPage(tableName, page, pagingUnit);
    }

    public List<Genre> findGenres(){
        return APIRepository.findGenres();
    };

    public List<ContentGenres> findContenteGenres(String tableName, int genre_id) {
        return APIRepository.findContentGenres(tableName, genre_id);
    }
}
