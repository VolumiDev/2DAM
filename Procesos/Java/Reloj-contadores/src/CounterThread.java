import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread implements Runnable{

    private AtomicInteger count;

    public CounterThread(AtomicInteger count) {
        this.count = count;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            count.incrementAndGet();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
