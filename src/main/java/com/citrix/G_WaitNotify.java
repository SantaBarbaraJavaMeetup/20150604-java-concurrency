package com.citrix;

import java.util.concurrent.CompletableFuture;

import static com.citrix.util.Log.log;

public class G_WaitNotify<T> {

    private T value;

    private CompletableFuture<T> future = new CompletableFuture<>();

    public synchronized T get() throws InterruptedException {
        while(value == null) {
            log("waiting...");
            wait();
        }

        return value;
    }

    public synchronized void set(T value) {
        this.value = value;
        log("notifying...");
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        G_WaitNotify<String> sync = new G_WaitNotify<>();

        Thread t = new Thread(() -> {
            try {
                log(sync.get());
            } catch (InterruptedException e) {
                log("interrupted");
            }
        });

        t.start();

//        t.interrupt();

        Thread.sleep(1000);

        sync.set("value");
    }

}
