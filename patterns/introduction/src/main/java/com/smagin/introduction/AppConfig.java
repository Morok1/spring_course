package com.smagin.introduction;

import com.smagin.introduction.accounts.AccountRepository;
import com.smagin.introduction.accounts.TransferRepository;
import com.smagin.introduction.accounts.TransferService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService(){
        return new TransferService();
    }

    @Bean
    public AccountRepository accountRepository(){
        return new AccountRepository();
    }

    @Bean
    public TransferRepository transferRepository(){
        return new TransferRepository();
    }
}
