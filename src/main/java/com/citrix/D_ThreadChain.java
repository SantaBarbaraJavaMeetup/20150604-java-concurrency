package com.citrix;

import static com.citrix.util.Log.log;

public class D_ThreadChain {

    public static void main(String[] args) throws Exception {
        Thread thread = null;
        for (int i=0; i<10; i++) {
            Thread last = thread;

            thread = new Thread(() -> {
                if(last != null) {
                    log("waiting for previous...");
                    try { last.join(); } catch (InterruptedException ignore) {}
                    log("done waiting");
                }

                log("sleeping a second...");
                try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
                log("done sleeping");
            });

            thread.start();
        }
    }

}
