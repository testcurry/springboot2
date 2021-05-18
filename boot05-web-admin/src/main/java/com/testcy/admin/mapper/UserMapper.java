package com.testcy.admin.mapper;

import com.testcy.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User getUserById(Integer id);

}
