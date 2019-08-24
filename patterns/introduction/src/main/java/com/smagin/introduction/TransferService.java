package com.smagin.introduction;

public class TransferService {
    private AccountRepository accountRepository;

    public TransferService() {
        this.accountRepository = AccountRepositoryFactory.getInstance("postgres");
    }
}
