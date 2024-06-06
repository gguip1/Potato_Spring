package Potato.Potato_Spring.repository;

import Potato.Potato_Spring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class JdbcMemberRepository implements MemberRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("userid");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("password", member.getPassword());
        parameters.put("name", member.getName());
        parameters.put("age", member.getAge());
        parameters.put("gender", member.getGender());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setUserid(key.toString());
        return member;
    }

    @Override
    public Optional<Member> findById(String userid) {
        List<Member> result = jdbcTemplate.query("select * from user where userid = ?", memberRowMapper(), userid);
        return result.stream().findAny();
    }

    private RowMapper<Member> memberRowMapper(){
        return new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setUserindex(rs.getInt("userindex"));
                member.setUserid(rs.getString("userid"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAge(rs.getInt("age"));
                member.setGender(rs.getInt("gender"));
                member.setType(rs.getInt("type"));

                return member;
            }
        };
    }
}
