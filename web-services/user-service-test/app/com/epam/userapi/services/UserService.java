package com.epam.userapi.services;

import com.epam.userapi.models.User;
import com.google.inject.ImplementedBy;
import com.epam.userapi.services.impl.UserServiceImpl;

/**
 * User Service.
 */
@ImplementedBy(UserServiceImpl.class)
public interface UserService extends CommonService<User> {}
