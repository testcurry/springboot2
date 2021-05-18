package com.testcy.admin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.testcy.admin.bean.Account;
import com.testcy.admin.mapper.AccountMapper;
import com.testcy.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_teacher", Long.class);
        log.info("查询的数量：{}",aLong);
        log.info("容器中的数据源类型：{}", dataSource.getClass().toString());
    }

    @Test
    void test01(){
        List<Account> list = accountMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void test02(){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("hello", "world");
        String hello = opsForValue.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }

}
