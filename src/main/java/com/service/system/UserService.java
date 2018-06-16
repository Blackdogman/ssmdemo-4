package com.service.system;

import com.model.system.User;

public interface UserService {

    User getUserByUserNameAndPassword(User user);
}
