package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;

import Potato.Potato_Spring.domain.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APIRepository {

    List<Count> getCount(String query);

    List<Genre> getGenre(String query);

    List<Content> getContent(String query);

    List<ContentGenres> getContentGenre(String query);
}
