package com.service.system;

import com.model.system.User;
import framework.utils.pageUtil.PagedResult;

import java.util.List;

public interface UserService {

    User getUserByUserNameAndPassword(User user);

    List<User> listAllUser();

    int addUser(User user);

    int deleteUser(String userId);

    User getUserByUserId(String userId);

    int updateUser(User user);

    PagedResult<User> listAllByPage(Integer pageNumber, Integer pageSize);
}
