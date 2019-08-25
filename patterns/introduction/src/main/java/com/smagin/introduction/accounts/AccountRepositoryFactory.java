package com.smagin.introduction.accounts;

public class AccountRepositoryFactory {
    public static AccountRepository getInstance(String type) {
        switch (type){
            case "postgres":
                return new JdbcRepository();
            case "MySQL":
                return new JdbcRepository();
            default:
                return new JdbcRepository();
        }

    }
}
