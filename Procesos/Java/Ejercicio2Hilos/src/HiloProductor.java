import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class HiloProductor implements Runnable {

    private ArrayList<Integer> cola;

    public HiloProductor(ArrayList<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        cola.add(randomInt(1,10));
        while (true) {
            synchronized (cola) {
                if (cola.size() == 20) {
                    System.out.println("NO PUEDE PRODUCIR NADA");
                    try {
                        cola.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Integer n = randomInt(1,10);
                    cola.add(n);
                    System.out.println("PRODUCTOR AÑADE "+ n + " / " + cola.size());
                    cola.notify();
                }
            }
            try {
                Thread.sleep(randomInt(100,700));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(cola.size() == 0){
                break;
            }
        }
    }

    private int randomInt(int l1, int l2) {
        return RandomGenerator.getDefault().nextInt(l1, l2);
    }
}
