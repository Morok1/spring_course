package com.smagin.introduction.accounts;

import com.smagin.introduction.configuration.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransferAccountMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
        TransferServiceImpl transferService = context.getBean(TransferServiceImpl.class);
        transferService.transfer(1,2);
        context.close();

    }
}
