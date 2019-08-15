package com.laxman.project.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laxman.project.entity.user;


@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
    
    @Transactional
    public user getUserInfo(String username){
    	
    	Session session=sessionFactory.getCurrentSession();    	
    	
    	NativeQuery query = session.createNativeQuery("select id, user_name, password, role FROM user where user_name = :username");
    	query.setParameter("username", username);
    	user u=new user();
    	List<Object[]> list=query.list();
    	for(Object[] o:list) {
    		u.setId((Integer)o[0]);
    		u.setUser_name(o[1].toString());
    		u.setPassword(o[2].toString());
    		u.setRole(o[3].toString());
    	}
    	return u;
    }
}