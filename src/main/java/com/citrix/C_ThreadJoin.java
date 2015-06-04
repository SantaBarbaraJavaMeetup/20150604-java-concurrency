package com.citrix;

import static com.citrix.util.Log.log;

public class C_ThreadJoin {

    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> {
            log("sleeping a second...");
            try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
            log("done sleeping");
        };

        Thread thread = new Thread(runnable);
        log("state: " + thread.getState());
        log("starting thread...");
        thread.start();
        log("started");
        log("state: " + thread.getState());

        log("joining thread...");
        thread.join();
        log("joined");
    }

}
