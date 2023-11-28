
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getValue() {
        return count.get();
    }
}

class IncrementerThread extends Thread {

    Counter counter;
    int times;

    public IncrementerThread(Counter counter, int times) {
        this.counter = counter;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            counter.increment();
        }
    }
}

public class SyncCounter {

    public static void main(String[] args) {

        Counter counter = new Counter();
        IncrementerThread[] it = new IncrementerThread[5];

        for(int i = 0; i < 5; i++) {
            it[i] = new IncrementerThread(counter, 1000);
        } 

        for(int i = 0; i < 5; i++) {
            it[i].start();
        }

        try {
            for (int i = 0; i < 5; i++) {
                it[i].join();
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(counter.getValue());
    }
}