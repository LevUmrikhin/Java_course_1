import java.time.*;
import java.util.*;

public class Runnable2 implements Runnable {
    int index;

    public Runnable2(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        List<String> myList = new ArrayList<>();
        if (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i <= YearMonth.of(2024, Month.values()[index]).lengthOfMonth(); i++) {
                myList.add(String.valueOf(i));
            }
            System.out.println(String.valueOf(Month.values()[index]) + " " + myList);
        } else {
            System.out.println("Thread interrupted: hello world");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 10000) {
            for (int i = 0; i < 12; i++) {
                Runnable month = new Runnable2(i);
                Thread thread = new Thread(month);
                thread.start();
                thread.join();
            }
            Thread.sleep(700);
        }

        System.out.println("hello World");
    }
}
