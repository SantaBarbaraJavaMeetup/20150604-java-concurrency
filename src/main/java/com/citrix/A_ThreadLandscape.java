package com.citrix;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.stream.Stream;

import static com.citrix.util.Log.log;

public class A_ThreadLandscape {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        log("state: " + thread.getState());
        log("name: " + thread.getName());
        log("id: " + thread.getId());
        log("priority: " + thread.getPriority());
        log("alive: " + thread.isAlive());
        log("daemon: " + thread.isDaemon());
        log("interrupted: " + thread.isInterrupted());
        log("group: " + thread.getThreadGroup());

        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] info = mxBean.dumpAllThreads(true, true);
        log("-----");
        log("jvm threads: " + info.length);
        Stream.of(info).forEach((i) -> log("name: " + i.getThreadName() + ", state: " + i.getThreadState()));
    }

}
