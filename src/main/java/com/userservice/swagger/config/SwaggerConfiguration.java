package com.userservice.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



public class SwaggerConfiguration {


	@EnableSwagger2
	@Configuration

	public class swaggerconfig {


		@Bean
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		}


	}
}