import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class Incremetar implements Runnable {
    private static AtomicInteger atInt;

    public Incremetar(AtomicInteger atInt) {
        this.atInt = atInt;
    }

    @Override
    public void run() {
        while (atInt.get() < 100) {
            synchronized (atInt) {
                atInt.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " incremento y ahora vale-----" + atInt.toString());
            }
            try {
                Thread.sleep(randomInt());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int randomInt() {
        return RandomGenerator.getDefault().nextInt(100, 1000);
    }

}
