package itsource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("itsource.dao")
@SpringBootApplication
public class YmApplication {
    public static void main(String[] args) {
        SpringApplication.run(YmApplication.class);
    }
}






