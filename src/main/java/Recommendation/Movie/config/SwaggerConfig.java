//package Recommendation.Movie.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("Recommendation.Movie"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//   /*private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Tech Interface - Spring Boot Swagger Configuration")
//                .description("\"Swagger configuration for application \"")
//                .version("1.1.0")
//                .license("Apache 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\")
//                .contact(new Contact("Ritika", "https://github.com/ritika1202", "wularitz@gmail.com"))
//                .build();
//    }*/
//
//}
