package com.smagin.introduction.accounts;

public class TransferServiceImpl implements TransferService {
    private AccountRepository accountRepository;

    public TransferServiceImpl() {
        this.accountRepository = AccountRepositoryFactory.getInstance("postgres");
    }

    @Override
    public void transfer(int number1, int number2) {
        accountRepository.transfer();
    }
}
