//package Potato.Potato_Spring.service;
//
//import Potato.Potato_Spring.domain.Content;
//import Potato.Potato_Spring.domain.ContentGenres;
//import Potato.Potato_Spring.domain.Count;
//import Potato.Potato_Spring.domain.Genre;
//import Potato.Potato_Spring.repository.APIRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class APIService {
//    private final APIRepository APIRepository;
//
//    @Autowired
//    public APIService(APIRepository APIRepository) {
//        this.APIRepository = APIRepository;
//    }
//
//    public List<Count> getCount(String query){
//        return APIRepository.getCount(query);
//    }
//
//    public List<Genre> getGenre(String query){
//        return APIRepository.getGenre(query);
//    }
//
//    public List<Content> getContent(String query){
//        return APIRepository.getContent(query);
//    }
//
//    public List<ContentGenres> getContentGenre(String query){
//        return APIRepository.getContentGenre(query);
//    }
//
//}
