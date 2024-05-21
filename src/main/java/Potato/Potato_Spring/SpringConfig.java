package Potato.Potato_Spring;

import Potato.Potato_Spring.repository.APIRepository;
import Potato.Potato_Spring.repository.JdbcTemplateAPIRepository;
import Potato.Potato_Spring.service.APIService;
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

    public APIService contentService(){
        return new APIService(contentRepository());
    }

    public APIRepository contentRepository(){
        return new JdbcTemplateAPIRepository(dataSource);
    }
}
