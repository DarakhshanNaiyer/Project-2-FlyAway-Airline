package com.flyaway.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.flyaway.constant.ErrorConstants;
import com.flyaway.constant.QueryConstants;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Admin;

public class AdminDaoImpl implements AdminDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public Admin validateAdmin(Admin login) {
		Admin admin = null;
		try {
		 admin = jdbcTemplate.queryForObject(QueryConstants.ADMIN_LOGIN, new AdminMapper(),login.getUsername().toLowerCase(), login.getPassword());
		}catch(Exception e)
		 {
			System.out.println(ErrorConstants.WRONG_CREDENTIALS);
		}
		return admin;
	}

	@Override
	public int UpdatePassword(Admin update) throws FAServiceException{
		return jdbcTemplate.update(QueryConstants.UPDATE_PASS, update.getNewpassword(), update.getUsername().toLowerCase());
	}

}

class AdminMapper implements RowMapper<Admin> {

	public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
		

		
		Admin admin = new Admin();
		admin.setUsername(rs.getString("username"));
		admin.setPassword(rs.getString("password"));

		return admin;
	}
}
