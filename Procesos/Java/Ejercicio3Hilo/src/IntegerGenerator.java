import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

public class IntegerGenerator implements Runnable {
    private ArrayList<Integer> lista;
    private RandomGenerator rand;

    public IntegerGenerator(ArrayList<Integer> lista) {
        this.lista = lista;
        rand = new SplittableRandom();
    }


    @Override
    public void run() {
        while (true) {
            synchronized (lista) {
                int number = rand.nextInt(100);
                lista.add(number);

            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(lista.size() >= 100){
                break;
            }
        }
    }
}
