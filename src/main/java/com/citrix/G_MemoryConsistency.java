package com.citrix;

public class G_MemoryConsistency {

    private static int a;
    private static int b;
    private static int r1;
    private static int r2;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            b = 1; // 1
            r2 = a; // 2
        });

        Thread t2 = new Thread(() -> {
            a = 2; // 3
            r1 = b; // 4
        });

        t1.start();
        t2.start();

        /**
         * hb(1, 2)
         * hb(3, 4)
         */
    }

}
