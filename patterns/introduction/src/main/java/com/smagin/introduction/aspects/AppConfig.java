package com.smagin.introduction.aspects;

import com.smagin.introduction.accounts.TransferService;
import com.smagin.introduction.accounts.TransferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public TransferService transferService(){
        return new TransferServiceImpl();
    }

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
