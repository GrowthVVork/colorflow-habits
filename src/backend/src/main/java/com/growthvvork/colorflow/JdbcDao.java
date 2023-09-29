package com.growthvvork.colorflow;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class JdbcDao<T> {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    
    public JdbcDao(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<T> query(String sql, RowMapper<T> rowMapper, Object... args){
        return jdbcTemplate.query(sql, rowMapper, args);
    }
}
