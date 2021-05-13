package com.testcy.boot;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Web01ApplicationTests {


    @Autowired
    private DruidDataSource dataSource;

    @Test
    void contextLoads() {

      log.info("数据源信息：{}",dataSource.getClass());

    }

}
