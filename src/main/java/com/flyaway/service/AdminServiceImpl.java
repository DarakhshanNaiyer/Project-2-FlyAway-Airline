package com.flyaway.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyaway.constant.ErrorConstants;
import com.flyaway.dao.AdminDao;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Admin;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public Admin validateAdmin(Admin login) throws FAServiceException{
		if (login.getUsername() == null || login.getUsername().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_USERNAME);
		}
		
		if (login.getPassword() == null || login.getPassword().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_PASSWORD);
		}
		return adminDao.validateAdmin(login);
	}

	
	
	public int UpdatePassword(Admin update) throws FAServiceException {
		
		if (update.getUsername() == null || update.getUsername().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_USERNAME);
		}
		if (update.getNewpassword() == null || update.getNewpassword().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_NEW_PASSWORD);
		}
		
		if (update.getNewpassword() == null || update.getNewpassword().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_CONFIRM_PASSWORD);
		}
		
		

		if(!update.getNewpassword().equals(update.getConfirmpassword())) {
			throw new FAServiceException(ErrorConstants.MISMATCH);		
		}

	



		return adminDao.UpdatePassword(update);
	}


}
