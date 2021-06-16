package com.hankun.satokenlearn.config;

import com.hankun.satokenlearn.constant.ReturnCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：hankun
 * @Description: 接口文档配置
 * @Date: 2021/6/8
 */
@EnableSwagger2WebMvc
@Configuration
public class Knife4jConfig {

    @Bean
    public Docket defaultApi2() {
            //添加全局响应状态码
            List<ResponseMessage> responseMessageList = new ArrayList<>();
            Arrays.stream(ReturnCode.values()).forEach(errorEnum -> {
                responseMessageList.add(
                        new ResponseMessageBuilder().code(errorEnum.getCode()).message(errorEnum.getMsg()).responseModel(
                                new ModelRef(errorEnum.getMsg())).build()
                );
            });
        return new Docket(DocumentationType.SWAGGER_2)
                // 添加全局响应状态码
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .contact(new Contact("hankun","",""))
                .version("1.0")
                .build();
    }
}
