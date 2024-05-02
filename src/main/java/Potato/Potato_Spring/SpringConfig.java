package Potato.Potato_Spring;

import Potato.Potato_Spring.repository.ContentRepository;
import Potato.Potato_Spring.repository.JdbcTemplateContentRepository;
import Potato.Potato_Spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public ContentService contentService(){
        return new ContentService(contentRepository());
    }

    public ContentRepository contentRepository(){
        return new JdbcTemplateContentRepository(dataSource);
    }
}
