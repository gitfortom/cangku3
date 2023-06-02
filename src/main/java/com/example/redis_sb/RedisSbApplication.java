package com.example.redis_sb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.redis_sb.mapper")
public class RedisSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSbApplication.class, args);
    }

}
