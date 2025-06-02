package com.harsh.springjdbc.model.repo;

import com.harsh.springjdbc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlienRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String sql = "insert into Alien(id,name,tech) values(?,?,?)";

        int row = jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Affected row: " + row);
    }
    public List<Alien> getallAlien(){
        String sql = "select * from Alien";

//        RowMapper mapper = new RowMapper() {
//            @Override
//            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Alien a = new Alien();
//                a.setId(rs.getInt(1));
//                a.setName(rs.getString(2));
//                a.setTech(rs.getString(3));
//                return a;
//            }
//        };
        RowMapper mapper = (ResultSet rs, int rowNum) -> {
            Alien a = new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(3));
            return a;
        };
        List<Alien> aliens = jdbcTemplate.query(sql,mapper);
        return aliens;
    }
}
