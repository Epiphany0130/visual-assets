package com.gyqstd.visualassets;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gyqstd.visualassets.mapper")
public class VisualAssetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualAssetsApplication.class, args);
    }

}
