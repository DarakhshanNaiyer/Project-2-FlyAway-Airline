package com.flyaway.dao;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.flyaway.constant.QueryConstants;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user)  throws FAServiceException {

    return jdbcTemplate.update(QueryConstants.USER_REGISTER, new Object[] {
    		user.getUsername().toLowerCase(), user.getPassword(), 
    		user.getFirstname().toLowerCase(), user.getLastname().toLowerCase(), 
    		user.getEmail().toLowerCase(), user.getAddress().toLowerCase(), 
    		user.getPhone() });
  }

}

