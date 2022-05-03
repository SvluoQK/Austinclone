package com.hao.mavenlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MavenlearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenlearnApplication.class, args);
    }

}
