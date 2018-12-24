package com.qunar.tools.flight.tools;

/**
 * Created by jiabin.niu on 2018.12.06 17:41
 */
public class ThreadInterrupted {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("niujiabin");
            }
        });
    }
}
