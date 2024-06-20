package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Exhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

@Repository
public class JdbcExhibitionRepository implements ExhibitionRepository{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcExhibitionRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Exhibition> getExhibition(String query) {
        return jdbcTemplate.query(query, exhibitionRowMapper());
    }

    private RowMapper<Exhibition> exhibitionRowMapper(){
        return (rs, rowNum) -> {
            Exhibition exhibition = new Exhibition();
            exhibition.setId(rs.getInt("exhibition_id"));
            exhibition.setTitle(rs.getString("title"));
            exhibition.setImg(rs.getString("img"));
            exhibition.setUrl(rs.getString("url"));
            exhibition.setType_(rs.getString("type_"));
            Date startDate = rs.getDate("start_date");
            Date endDate = rs.getDate("end_date");

            exhibition.setStart_date(startDate);
            exhibition.setEnd_date(endDate);
            return exhibition;
        };
    }
}
