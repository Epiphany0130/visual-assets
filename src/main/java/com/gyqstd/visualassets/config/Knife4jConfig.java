package com.gyqstd.visualassets.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j配置类
 * @author GuYuqi
 * @version 1.0
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("visual-assets-api-doc") // API 文档标题
                        .version("1.0") // API 版本
                        .description("视觉资产管理系统API文档")); // API 描述
    }
}
