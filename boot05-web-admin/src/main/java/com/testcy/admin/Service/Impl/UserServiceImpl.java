package com.testcy.admin.Service.Impl;

import com.testcy.admin.Service.UserService;
import com.testcy.admin.bean.User;
import com.testcy.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }
}
