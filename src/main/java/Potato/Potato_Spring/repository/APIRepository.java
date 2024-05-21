package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;

import Potato.Potato_Spring.domain.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface APIRepository {
    List<Content> findAllByPage(String tableName, int page, int pagingUnit);
    List<Count> countAll(String table);
    List<Genre> findGenres();

    List<ContentGenres> findContentGenres(String tableName, int genre_id);
}
