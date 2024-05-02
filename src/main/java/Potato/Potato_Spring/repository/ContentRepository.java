package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Content;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository {
    Content save(Content content);
    Optional<Content> findById(int id);
    Optional<Content> findByName(String title);
    List<Content> findAll();
}
