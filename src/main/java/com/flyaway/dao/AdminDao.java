package com.flyaway.dao;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Admin;

public interface AdminDao {

	public Admin validateAdmin(Admin login) throws FAServiceException;

	public int UpdatePassword(Admin update)throws FAServiceException;

}


