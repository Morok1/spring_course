package com.smagin.gof.accountFactory;

import com.smagin.gof.accountFactory.api.Account;
import com.smagin.gof.accountFactory.model.CurrentAccount;
import com.smagin.gof.accountFactory.model.SavingAccount;

public class
AccountFactory {
    final String CURRENT_ACCOUNT = "CURRENT";
    final String SAVING_ACCOUNT = "SAVING";

    public Account getAccount(String accountType){
        if(CURRENT_ACCOUNT.equals(accountType)){
            return new CurrentAccount();
        } else if (SAVING_ACCOUNT.equals(accountType)){
            return new SavingAccount();
        }
        return null;
    }
}
