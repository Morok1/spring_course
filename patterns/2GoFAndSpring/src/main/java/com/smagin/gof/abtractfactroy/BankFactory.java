package com.smagin.gof.abtractfactroy;

import com.smagin.gof.abtractfactroy.model.Bank;
import com.smagin.gof.accountFactory.api.Account;

public class BankFactory extends AbstractFactory {
    @Override
    public Bank getBank(String typeOfBank) {

        return null;
    }

    @Override
    public Account getAccount(String typeOfAccount) {
        return null;
    }
}
