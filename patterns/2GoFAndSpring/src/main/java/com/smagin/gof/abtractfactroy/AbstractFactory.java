package com.smagin.gof.abtractfactroy;

import com.smagin.gof.abtractfactroy.model.Bank;
import com.smagin.gof.accountFactory.api.Account;

public abstract class AbstractFactory {
    public abstract Bank getBank(String typeOfBank);
    public abstract Account getAccount(String typeOfAccount);
}
