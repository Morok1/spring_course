package com.smagin.introduction.configuration;

import com.smagin.introduction.accounts.AccountRepository;
import com.smagin.introduction.accounts.TransferRepository;
import com.smagin.introduction.accounts.TransferService;
import com.smagin.introduction.accounts.TransferServiceImpl;
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
        return new AccountRepositoryImpl
                ();
    }

    @Bean
    public TransferRepository transferRepository(){
        return new TransferRepository();
    }
}
