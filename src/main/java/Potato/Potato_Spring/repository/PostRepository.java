package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {
    public Post post(Post post);
}
