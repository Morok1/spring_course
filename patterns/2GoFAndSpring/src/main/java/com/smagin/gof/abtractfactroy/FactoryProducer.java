package com.smagin.gof.abtractfactroy;

import com.sun.org.apache.bcel.internal.generic.FADD;

public class FactoryProducer {
    final static String BANK = "BANK";
    final static String  ACCOUNT = "ACCOUNT";

    public static AbstractFactory getFactory(String factory){
        if(BANK.equalsIgnoreCase(factory))
            return new BankFactory();
        if(ACCOUNT.equalsIgnoreCase(factory))
            return new AccountFactory();
        return null;
    }
}
