package com.smagin.gof.abtractfactroy;

import com.smagin.gof.abtractfactroy.model.Bank;
import com.smagin.gof.accountFactory.api.Account;
import com.smagin.gof.accountFactory.model.CurrentAccount;
import com.smagin.gof.accountFactory.model.SavingAccount;

public class AccountFactory  extends AbstractFactory{
    final String CURRENT = "CURRENT";
    final String SAVING = "SAVING";
    @Override
    public Bank getBank(String typeOfBank) {
        return null;
    }

    @Override
    public Account getAccount(String typeOfAccount) {
        switch(typeOfAccount){
            case CURRENT:
                return new CurrentAccount();
            case SAVING:
                return new SavingAccount();
           default:
               return null;
        }
    }
}
