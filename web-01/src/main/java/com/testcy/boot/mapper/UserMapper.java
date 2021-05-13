package com.testcy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.testcy.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<Account> {

    @Select("select *from t_account where id=#{id}")
    public Account getById(long id);

}
