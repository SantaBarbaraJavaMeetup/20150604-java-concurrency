package com.citrix;

import static com.citrix.util.Log.log;

public class B_SleepAndInterrupt {

    public static void main(String[] args) throws Exception {
        Thread thread = Thread.currentThread();

        log("sleeping for a second...");
        Thread.sleep(1000);
        log("done sleeping");

        log("interrupting current thread, then sleeping");
        thread.interrupt();
        log("interrupted: " + thread.isInterrupted());

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            log("interrupted exception");
        }

        log("interrupted: " + thread.isInterrupted());
    }

}
