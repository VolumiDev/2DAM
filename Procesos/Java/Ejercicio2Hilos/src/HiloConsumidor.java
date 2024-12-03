import java.util.ArrayList;
import java.util.random.RandomGenerator;

public class HiloConsumidor implements Runnable {

    private static ArrayList<Integer> cola;

    public HiloConsumidor(ArrayList<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            synchronized (cola) {
                if (cola.size() != 0) {
                    Integer n = cola.remove(cola.size() - 1);
                    System.out.println("CONSUMIDOR SACA 1: " + n + " / " + cola.size());
                    cola.notify();
                }
            }
            if (cola.size() == 0) {
                break;
            }
            try {
                Thread.sleep(randomInt(100, 700));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int randomInt(int l1, int l2) {
        return RandomGenerator.getDefault().nextInt(l1, l2);
    }
}
