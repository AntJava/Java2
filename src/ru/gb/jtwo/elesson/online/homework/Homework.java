package ru.gb.jtwo.elesson.online.homework;

import java.util.Arrays;

public class Homework {

    static final int size = 10000000;
    static final int h = size / 2;

    private static void noSync(){
        float[] arr = new float[size];
        Arrays.fill(arr,1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a + " ms for noSync method");
    }

    private static void sync(){
        float[] arr = new float[size];
        Arrays.fill(arr,1);

        long a = System.currentTimeMillis();

        float[] a1 = new float [h];
        float[] a2 = new float [h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        arrThread s2 = new arrThread("Last half", a2, h);
        arrThread s1 = new arrThread("First half", a1, 0);

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a + " ms for sync method");
    }

    private static class arrThread extends Thread {
        int startI = 0;
        float[] arr;

        public arrThread(String name, float[] arr, int startI){
            super(name);
            this.arr = arr;
            this.startI = startI;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+startI) / 5) * Math.cos(0.2f + (i+startI) / 5) * Math.cos(0.4f + (i+startI) / 2));
            }
            System.out.println("Done with thread"+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        noSync();
        sync();
    }
}
