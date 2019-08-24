package com.smagin.introduction.accounts;

public class AccountRepositoryFactory {
    public static AccountRepository getInstance(String type) {
        switch (type){
            case "postgres":
                return new AccountRepository();
            case "MySQL":
                return new AccountRepository();
            default:
                return new AccountRepository();
        }

    }
}