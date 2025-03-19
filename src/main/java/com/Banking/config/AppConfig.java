package com.Banking.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Banking.dto.response.TransactionResponse;
import com.Banking.entity.Transaction;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Custom mapping to resolve the conflict
        modelMapper.addMappings(new PropertyMap<Transaction, TransactionResponse>() {
            @Override
            protected void configure() {
                map().setAccountId(source.getAccount().getAccountId());  // ✅ Explicitly map accountId
            }
        });

        return modelMapper;
    }
}
