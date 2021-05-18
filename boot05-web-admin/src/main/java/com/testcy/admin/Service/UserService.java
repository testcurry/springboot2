package com.testcy.admin.Service;

import com.testcy.admin.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User queryUser(Integer id) ;

}
