package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class JdbcTemplateContentRepository implements ContentRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateContentRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Content save(Content content) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("movie_test").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", content.getTitle());
        parameters.put("img", content.getImg());
        parameters.put("description", content.getDescription());
        parameters.put("director", content.getDirector());
        parameters.put("actor", content.getActor());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        content.setId(key.intValue());

        return content;
    }

    @Override
    public Optional<Content> findById(int id) {
        List<Content> result = jdbcTemplate.query("select * from movie_test where id = ?", contentRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Content> findByName(String title) {
        List<Content> result = jdbcTemplate.query("select * from movie_test where title = ?", contentRowMapper(), title);
        return result.stream().findAny();
    }

    @Override
    public List<Content> findAll() {
        return jdbcTemplate.query("select * from movie_test", contentRowMapper());
    }

    /**
     * tableName : 검색하고자 하는 테이블 명
     * page : 페이지수
     * page는 10개씩 조회
     *
     * @return
     */
    @Override
    public List<Content> findAllByPage(String tableName, int page, int pagingUnit){
        return jdbcTemplate.query("SELECT * FROM " + tableName + " ORDER BY id ASC LIMIT " + pagingUnit + " OFFSET " + page * pagingUnit, contentRowMapper());
    }

    /**
     * 테이블 갯수
     * findAllByPage에서 페이지 개수를 확인하기 위함
     * @return
     */
    @Override
    public long countAll(String tableName){
//        List<Content> result = jdbcTemplate.query("SELECT COUNT(*) FROM " + tableName, contentRowMapper());
        List<Content> result = jdbcTemplate.query("SELECT * FROM " + tableName, contentRowMapper());
        return result.stream().count();
    }

    /**
     * Content 형식의 쿼리 result 맵핑
     */
    private RowMapper<Content> contentRowMapper(){
        return (rs, rowNum) -> {
            Content content = new Content();
            content.setId(rs.getInt("id"));
            content.setImg(rs.getString("img"));
            content.setTitle(rs.getString("title"));
            content.setDescription(rs.getString("description"));
            content.setDirector(rs.getString("director"));
            content.setActor(rs.getString("actor"));
            return content;
        };
    }

    /**
     *
     */

}
