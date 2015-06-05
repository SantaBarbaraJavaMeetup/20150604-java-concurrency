package com.citrix.util;

public class Counter {

    private int n;

    public synchronized void increment() {
        n++;
    }

    public synchronized void decrement() {
        n--;
    }

    public synchronized int get() {
        return n;
    }

}
