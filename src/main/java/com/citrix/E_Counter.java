package com.citrix;

import static com.citrix.util.Log.log;

public class E_Counter {

    private int n;

    public void increment() {
        n++;
    }

    public void decrement() {
        n--;
    }

    public int get() {
        return n;
    }

    public static void main(String[] args) {
        int numThreads = 2;

        E_Counter counter = new E_Counter();

        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                int lastCount = -1;

                while(true) {
                    counter.increment();
                    counter.decrement();

                    int count = counter.get();
                    if(lastCount != count) {
                        log(count);
                    }

                    lastCount = count;
                }
            }).start();
        }
    }

}
