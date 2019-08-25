package com.smagin.gof.accountFactory;

import com.smagin.gof.accountFactory.api.Account;

public class FactoryPatternMain {
    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory();

        Account savingAccount = accountFactory.getAccount("SAVING");
        Account currentAccount = accountFactory.getAccount("CURRENT");

    }
}
