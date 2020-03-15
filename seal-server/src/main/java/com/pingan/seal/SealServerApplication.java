package com.pingan.seal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pingan.seal.mapper")
public class SealServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SealServerApplication.class, args);
    }

}
