package com.citrix;

import static com.citrix.util.Log.log;

public class D_ThreadChain {

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[10];
        for (int i=0; i<threads.length; i++) {
            int index = i;
            threads[i] = new Thread(() -> {
                if(index > 0) {
                    log("waiting for previous...");
                    try { threads[index-1].join(); } catch (InterruptedException ignore) {}
                    log("done waiting");
                }

                log("sleeping a second...");
                try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
                log("done sleeping");
            });

            threads[i].start();
        }
    }

}
