package Potato.Potato_Spring.service;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.repository.ContentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ContentServiceTest {
    @Autowired
    ContentService contentService;
    @Autowired
    ContentRepository contentRepository;

    @Test
    void insert(){
        Content content = new Content();
        content.setTitle("");
        content.setImg("");
        content.setDescription("");
        content.setDirector("");
        content.setActor("");

        int saveid = contentService.join(content);

        Content findContent = contentService.findContent(saveid).get();
        assertThat(content.getTitle()).isEqualTo(findContent.getTitle());
    }

    @Test
    void valid(){
        Content content_1 = new Content();
        content_1.setTitle("spring");
        content_1.setImg("");
        content_1.setDescription("");
        content_1.setDirector("");
        content_1.setActor("");

        Content content_2 = new Content();
        content_2.setTitle("spring_2");
        content_2.setImg("");
        content_2.setDescription("");
        content_2.setDirector("");
        content_2.setActor("");

        contentService.join(content_1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> contentService.join(content_2));
    }

//    @Test
//    void findAllByPageTest(){
//        Optional<Content> result = contentService.findAllByPage("movie_test", 1);
//        System.out.println(result);
//    }
}
