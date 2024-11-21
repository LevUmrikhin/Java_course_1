package ru.isys.trainings.task10;

import java.time.*;
import java.util.*;

public class Runnable2 implements Runnable {
    int index;
    name3 name;

    public Runnable2(int index, name3 name) {
        this.index = index;
        this.name = name;
    }
         static class name3 {

        public synchronized void wait2(){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        public synchronized void notify2(){
            notify();
        }
    }

    @Override
    public void run() {
        name.wait2();
        List<String> myList = new ArrayList<>();
        if (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i <= YearMonth.of(2024, Month.values()[index]).lengthOfMonth(); i++) {
                myList.add(String.valueOf(i));
            }
            System.out.println(String.valueOf(Month.values()[index]) + " " + myList);
        } else {
            System.out.println("Thread interrupted: hello world");
        }
        name.notify2();
    }

    public static void main(String[] args) throws InterruptedException {
        name3 name2 = new name3();
        long startTime = System.currentTimeMillis();

            while(System.currentTimeMillis() - startTime < 10000) {
                for (int i = 0; i < 12; i++) {
                    Runnable month = new Runnable2(i, name2);
                    Thread thread = new Thread(month);
                    thread.start();

                }
                name2.notify2();
                Thread.sleep(700);
            }




        System.out.println("hello World");
    }
}
