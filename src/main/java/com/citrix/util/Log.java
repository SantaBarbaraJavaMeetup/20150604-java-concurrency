package com.citrix.util;

public class Log {

    public static void log(Object message) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + message);
    }

}
