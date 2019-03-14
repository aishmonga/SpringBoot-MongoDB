package com.stackroute.player.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
//@PropertySource("classpath:swagger.properties")
//@ComponentScan(basePackageClasses = PlayerController.class)
@Configuration
public class SwaggerConfig {

//    private static final String SWAGGER_API_VERSION = "1.0";
//    private static final String LICENSE_TEXT = "License";
//    private static final String title = "Fastest Click First REST API";
//    private static final String description = "RESTful API for FCF Game" ;

//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title(title)
//                .description(description)
//                .license(LICENSE_TEXT)
//                .version(SWAGGER_API_VERSION)
//                .build();
//    }


//    @Bean
//    public Docket gameApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
////                .apiInfo(apiInfo())
////                .pathMapping("/")
//                .select()
//                .paths(regex("api.* "))
//                .build();
//    }


    @Bean
    public Docket gameApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .select().apis(RequestHandlerSelectors.basePackage("com.stackroute.player"))

                .paths(regex("/api/v1/.*"))

                .build();

    }
}
