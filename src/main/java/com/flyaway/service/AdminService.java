package com.flyaway.service;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Admin;

public interface AdminService {

  public Admin validateAdmin(Admin login) throws FAServiceException;
  
  public int UpdatePassword(Admin update)throws FAServiceException;
	 
}
