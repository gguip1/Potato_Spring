package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Content;
import Potato.Potato_Spring.domain.ContentGenres;
import Potato.Potato_Spring.domain.Count;

import Potato.Potato_Spring.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class JdbcAPIRepository implements APIRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAPIRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Count> getCount(String query){
        return jdbcTemplate.query(query, countRowMapper());
    }

    @Override
    public List<Genre> getGenre(String query){
        return jdbcTemplate.query(query, genreRowMapper());
    }

    @Override
    public List<Content> getContent(String query){
        return jdbcTemplate.query(query, contentRowMapper());
    }

    @Override
    public List<ContentGenres> getContentGenre(String query){
        return jdbcTemplate.query(query, contentGenresRowMapper());
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
