package com.smagin.gof.singleton;

public class Singleton {
    private static Singleton INSTANCE = null;

    public Singleton getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return null;
    }
}
