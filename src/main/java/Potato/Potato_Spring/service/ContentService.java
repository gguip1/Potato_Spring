package Potato.Potato_Spring.service;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public int join(Content content){
        validateDuplicateContent(content);

        contentRepository.save(content);
        return content.getId();
    }

    private void validateDuplicateContent(Content content){
        contentRepository.findByName(content.getTitle())
                .ifPresent(c -> {
                    throw new IllegalStateException("이미 존재하는 Content");
                });
    }

    public List<Content> findAllByPage(String tableName, int page, int pagingUnit){
        return contentRepository.findAllByPage(tableName, page, pagingUnit);
    }
    public long countAll(String tableName){
        return contentRepository.countAll(tableName);
    }
    public List<Content> findContents(){
        return contentRepository.findAll();
    }

    public Optional<Content> findContent(int id){
        return contentRepository.findById(id);
    }
}
