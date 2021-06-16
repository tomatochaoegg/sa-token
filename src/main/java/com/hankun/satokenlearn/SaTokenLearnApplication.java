package com.hankun.satokenlearn;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.hankun.satokenlearn.mapper")
public class SaTokenLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenLearnApplication.class, args);
    }

}
