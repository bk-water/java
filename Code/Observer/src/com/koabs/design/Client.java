package com.koabs.design;

/**
 * Created by kevin1 on 7/6/15.
 */
public class Client {

    public static void main(String[] agr){
        Observer ob = new ConcreteObserverA();

        ConcreteSubjectA sa = new ConcreteSubjectA();
        sa.Attach(ob);
        sa.Notify();
    }
}
