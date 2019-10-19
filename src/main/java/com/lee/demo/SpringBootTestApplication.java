package com.lee.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.lee.demo.dao")
@EnableCaching
public class SpringBootTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootTestApplication.class, args);
	}

}
