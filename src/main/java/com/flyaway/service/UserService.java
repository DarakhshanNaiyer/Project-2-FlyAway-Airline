package com.flyaway.service;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.User;

public interface UserService {

  public int register(User user) throws FAServiceException;

}
