import java.util.concurrent.locks.ReentrantLock;

public class ThradReentrarLock implements Runnable{


    /**
     * Runs this operation.
     */

    private int count;
    private final ReentrantLock lock;

    public ThradReentrarLock(int count, ReentrantLock lock) {
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            lock.lock();
            try {
                count++;
                System.out.println(Thread.currentThread().getName() + "Incremented value :" + count);
            }finally {
                lock.unlock();
            }
        }
    }

    public int getCount() {
        return count;
    }
}
