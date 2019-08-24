package com.smagin.introduction.accounts;

import com.smagin.introduction.accounts.AccountRepository;
import com.smagin.introduction.accounts.AccountRepositoryFactory;

public class TransferService {
    private AccountRepository accountRepository;

    public TransferService() {
        this.accountRepository = AccountRepositoryFactory.getInstance("postgres");
    }
}
