package com.laxman.project.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laxman.project.entity.user;


@Repository
public class UserDAO {

	private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Transactional
    public user getUserInfo(String username){
    	String sql = "SELECT id, user_name, password, role FROM user where user_name = ?";

    	user userInfo = (user)jdbcTemplate.queryForObject(sql, new Object[]{username},
    		new RowMapper<user>() {
	            public user mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	user user = new user();
	            	user.setId(rs.getInt("id"));
	                user.setUser_name(rs.getString("user_name"));
	                user.setPassword(rs.getString("password"));
	                user.setRole(rs.getString("role"));
	                return user;
	            }
        });
    	return userInfo;
    }
}