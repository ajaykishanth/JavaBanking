package com.Banking.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Banking.dto.response.TransactionResponse;
import com.Banking.entity.Transaction;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	 @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();

	        modelMapper.addMappings(new PropertyMap<Transaction, TransactionResponse>() {
	            @Override
	            protected void configure() {
	                map().setAccountId(source.getUserAccount().getAccountId()); // Map accountId from UserAccount to TransactionResponse
	            }
	        });

	        return modelMapper;
	    }


    @Bean
    public OpenAPI bankingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Banking API")
                        .description("API documentation for Banking System")
                        .version("1.0"));
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(); // ✅ Bean to make external REST API calls
    }
}
