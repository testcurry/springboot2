package com.testcy.admin.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.testcy.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("account")
public interface AccountMapper extends BaseMapper<Account> {

}
