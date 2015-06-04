package com.citrix;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.citrix.util.Log.log;

public class F_Volatile {

    private volatile Set<Integer> values;

    private void compute() {
        /**
         * Some expensive operation...
         */
        Set<Integer> set = IntStream.range(0, (int)(Math.random()*10) + 1)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toSet());

        this.values = set;
    }

    public Set<Integer> get() {
        return values;
    }

    public static void main(String[] args) {
        F_Volatile obj = new F_Volatile();

        new Thread(() -> {
            while(true) {
                obj.compute();
                log("computed new values");
                try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
            }
        }).start();

        while(true) {
            log(obj.get());
            try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
        }
    }

}
