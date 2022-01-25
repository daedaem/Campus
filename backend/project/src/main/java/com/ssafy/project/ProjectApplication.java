package com.ssafy.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @SpringBootApplication(scanBasePackages = { "com.ssafy.project" })
// @SpringBootApplication(scanBasePackages = { "com.ssafy.project.dao" })
@SpringBootApplication
// @ComponentScan(value = "com.ssafy.project.dao")
// @MapperScan(basePackages = { "com.ssafy.project.dao" })
@EnableSwagger2
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
