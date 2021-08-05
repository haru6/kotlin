package com.squadra.kotlin.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

   private fun metaData() = ApiInfoBuilder()
        .title("Kotlin")
        .description("Projeto Squadra")
        .version("1.0.0")
        .build()

    @Bean
    fun productApi() = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.squadra.kotlin"))
        .paths(PathSelectors.regex("/api.*")
        ).build()
        .apiInfo(metaData())
}
