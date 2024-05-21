package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;

import Potato.Potato_Spring.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class JdbcTemplateAPIRepository implements APIRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateAPIRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    /**
     * tableName : 검색하고자 하는 테이블 명
     * page : 페이지수
     * page는 10개씩 조회
     *
     */
    @Override
    public List<Content> findAllByPage(String tableName, int page, int pagingUnit){
        return jdbcTemplate.query("SELECT * FROM " + tableName + " ORDER BY id ASC LIMIT " + pagingUnit + " OFFSET " + page * pagingUnit, contentRowMapper());
    }

    /**
     * 테이블 갯수
     * findAllByPage에서 페이지 개수를 확인하기 위함
     *
     */
    @Override
    public List<Count> countAll(String tableName){
//        List<Content> result = jdbcTemplate.query("SELECT COUNT(*) FROM " + tableName, contentRowMapper());
        return jdbcTemplate.query("SELECT count(*) as cnt FROM " + tableName, countRowMapper());
    }

    @Override
    public List<Genre> findGenres() {
        return jdbcTemplate.query("SELECT * FROM genre", genreRowMapper());
    }

    @Override
    public List<ContentGenres> findContentGenres(String tableName, int genre_id) {
        return jdbcTemplate.query("SELECT * FROM " + tableName + " WHERE genre_id = " + genre_id, contentGenresRowMapper());
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

    private RowMapper<Count> countRowMapper(){
        return (rs, rowNum) -> {
            Count count = new Count();
            count.setCnt(rs.getInt("cnt"));
            return count;
        };
    }

    private RowMapper<Genre> genreRowMapper(){
        return (rs, rowNum) -> {
            Genre genre = new Genre();
            genre.setGenre_id(rs.getInt("genre_id"));
            genre.setGenre_name(rs.getString("genre_name"));
            return genre;
        };
    }

    private RowMapper<ContentGenres> contentGenresRowMapper(){
        return (rs, rowNum) -> {
            ContentGenres contentGenres = new ContentGenres();
            contentGenres.setId(rs.getInt("id"));
            contentGenres.setGenre_id(rs.getInt("genre_id"));
            return contentGenres;
        };
    }
}
