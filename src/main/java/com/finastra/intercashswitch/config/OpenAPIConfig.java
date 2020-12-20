/**
 * 
 */
package com.finastra.intercashswitch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author Vipin.Mangalkar
 *
 */
@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI()
	            .info(
	                new Info()
	                    .title("Bank - Inter Cash Switch API")
	                    .version("1.0")
	                    .termsOfService("http://swagger.io/terms/")
	                    .license(new License().name("Apache 2.0").url("http://springdoc.org"))
	            );
	}
}
