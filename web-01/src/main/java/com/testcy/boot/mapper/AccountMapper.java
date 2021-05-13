package com.testcy.boot.mapper;

import com.testcy.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {


    public Account getAccountById(long id);

}
