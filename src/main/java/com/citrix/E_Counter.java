package com.citrix;

import com.citrix.util.Counter;

import static com.citrix.util.Log.log;

public class E_Counter {

    public static void main(String[] args) {
        int numThreads = 2;

        Counter counter = new Counter();

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
