package ru.isys.trainings.task11;
import java.util.*;
public class Bank {
    int[] accounts = new int[10];
    public Bank() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = 100;
        }
    }
    public void PrintSum() {

        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum = sum + accounts[i];
        }
        System.out.println(sum);
    }
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum = sum + accounts[i];
        }
        return sum;
    }
}
