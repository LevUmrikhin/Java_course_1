import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.isys.trainings.task11.Bank;


public class ThreadPool {
    public static void main(String[] args) {
        // Create a list of 1000 tasks
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            tasks.add(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    account[(int) (Math.random() * 9 + 1)] += (new Random().nextBoolean() ? 1 : -1) * (Math.random() * 9 + 10);
                    Thread.sleep(100);
                    PrintSum();
                    System.out.println("Task executed by " + Thread.currentThread().getName());
                    return null;
                }
            });
        }

        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        int a  = account.getSum();
        while(System.currentTimeMillis() - startTime < 100000 || account.getSum() == a) {
            for (Callable<Void> task : tasks) {
                executorService2.submit(task);
            }
        }
        executorService2.shutdown();
    }
}
