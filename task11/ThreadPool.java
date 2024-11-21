package ru.isys.trainings.task11;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import ru.isys.trainings.task11.Bank;


public class ThreadPool {
    public static void main(String[] args) {
        // Create a list of 1000 tasks
        List<Callable<Void>> tasks = new ArrayList<>();
        Bank bank = new Bank();
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 1000; i++) {
            tasks.add(new Callable<Void>() {
                @Override
                public Void call() throws Exception {

                    int a = (int)  (Math.random() * 9 + 10);
                    int account_number_1 = (int) Math.random() * 9 + 1;
                    int account_number_2 = (int) Math.random() * 9 + 1;
                    if(account_number_1 == account_number_2) {
                        if (account_number_2 > 0) {
                            account_number_2--;
                        } else {
                            account_number_2++;
                        }
                    }
                    lock.lock();  // block until condition holds
                    try {
                        bank.accounts[account_number_1] += a;
                        bank.accounts[account_number_2] -= a;
                    } finally {
                        lock.unlock();
                    }
                    
                    Thread.sleep(100);
                    bank.PrintSum();
                    System.out.println("Task executed by " + Thread.currentThread().getName());
                    return null;
                }
            });
        }

        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        int a  = bank.getSum();
        for (Callable<Void> task : tasks) {
            executorService2.submit(task);
            if(! (System.currentTimeMillis() - startTime < 100000 && bank.getSum() == a)){
                break;
            }
        }
        executorService2.shutdown();
        bank.PrintSum();
    }
}
