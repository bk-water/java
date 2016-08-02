package com.koabs.design.observer;

/**
 * Created by kevin1 on 7/6/15.
 */
public class ConcreteObserverA extends Observer{
    @Override
    public void Update() {
       System.out.println("Observer update.");
    }
}
