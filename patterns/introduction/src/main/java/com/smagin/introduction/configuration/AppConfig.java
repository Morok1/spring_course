package com.smagin.introduction.configuration;

import com.smagin.introduction.accounts.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService(){
        return new TransferServiceImpl();
    }

    @Bean
    public AccountRepository accountRepository(){
        return new JdbcRepository();
    }

    @Bean
    public TransferRepository transferRepository(){
        return new TransferRepository();
    }
}
