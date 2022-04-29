package com.nona;

/**
 * example 1
 */
public class Sequence implements Runnable {

    public static int i = 0;

    @Override
    public void run() {
        ++i;
    }

}
