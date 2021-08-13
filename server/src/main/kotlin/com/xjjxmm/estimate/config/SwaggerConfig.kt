package com.xjjxmm.estimate.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfig {
    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
            //.select()
            //.apis(RequestHandlerSelectors.any())
           // .paths(PathSelectors.any()).build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("xjjxmm API Doc")
            .description("This is a restful api document of xjjxmm.")
            .version("1.0")
            .build()
    }
}