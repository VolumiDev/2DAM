import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class Decrementar implements Runnable{

    private static AtomicInteger atInt;

    public Decrementar(AtomicInteger atInt) {
        this.atInt = atInt;
    }

    @Override
    public void run() {
        while(atInt.get() < 100){
            synchronized (atInt){
                atInt.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + " decremento y ahora vale-----" + atInt.toString());

            }
            try {
                Thread.sleep(randomInt());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private int randomInt(){
        return RandomGenerator.getDefault().nextInt(100, 1000 );
    }

}
