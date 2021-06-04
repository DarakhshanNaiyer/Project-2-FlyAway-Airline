package com.flyaway.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyaway.constant.ErrorConstants;
import com.flyaway.dao.UserDao;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user)  throws FAServiceException{
	  
	  if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_USERNAME);
		}
	  
	  if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_PASSWORD);
		}
	  
	  if (user.getFirstname() == null || user.getFirstname().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_USERNAME);
		}
	  
	  if (user.getLastname() == null || user.getLastname().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_LASTNAME);
		}
	  
	  if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_EMAIL);
		}
	  
	  if (user.getAddress() == null || user.getAddress().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_ADDRESS);
		}
	  
	  if (user.getPhone() == 0 || user.getPhone()== null) {
			throw new FAServiceException(ErrorConstants.EMPTY_CONTACTNO);
		}
	  
	  
	  
    return userDao.register(user);
  }

}
