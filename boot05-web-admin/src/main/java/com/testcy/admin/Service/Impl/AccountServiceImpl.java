package com.testcy.admin.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.testcy.admin.Service.AccountService;
import com.testcy.admin.bean.Account;
import com.testcy.admin.mapper.AccountMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {



}
