package kr.co.fw.config;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("kr.co.fw.api"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getArrayList())
				;
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"로봇 설계 매니저(Robot Plan Manager) REST API",
				"로봇 설계 매니저 API",
				"v0.1", 
				"", // "Terms of Service",
				// new Contact("Insuplanet Developer", "www.kr.co.fw.co.kr", "choiys@kr.co.fw.co.kr"), "License of API", "API License URL", Collections.emptyList()
				new Contact("", "", ""), "Private License of API", null, Collections.emptyList()
				);
		
	}
	
	private ArrayList<ResponseMessage> getArrayList(){
		ArrayList<ResponseMessage> lists = new ArrayList<ResponseMessage>();
		lists.add(new ResponseMessageBuilder().code(500).message("서버 에러").responseModel(new ModelRef("Error")).build());
		lists.add(new ResponseMessageBuilder().code(403).message("권한 없음").responseModel(new ModelRef("Forbbiden")).build());
		return lists;
	}
	
	
}
