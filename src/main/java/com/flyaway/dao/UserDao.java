package com.flyaway.dao;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.User;

public interface UserDao {

  public int register(User user) throws FAServiceException;

}
