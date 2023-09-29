package com.growthvvork.colorflow.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.growthvvork.colorflow.model.User;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      //Dummy lines to check working
      user.setUserId(rs.getLong("user_id"));
      user.setUserName(rs.getString("user_name"));
      user.setUserPassword(rs.getString("user_password"));
      return user;
   }
}


