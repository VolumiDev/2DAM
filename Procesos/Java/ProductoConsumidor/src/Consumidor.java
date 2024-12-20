import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Consumidor implements Runnable{

    private int cant;
    private final ArrayList<Integer> cesta;

    Consumidor(ArrayList<Integer> cesta){
        cant = 0;
        this.cesta = cesta;
    }


    public Integer generaUnds() {
        Random rng = new Random();
        int cant = rng.nextInt(3)+1;
        return (Integer) cant;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (cesta){
                cant = generaUnds();
                if (cesta.size() >= cant){
                    for (int i = 0; i <cant ; i++) {
                        cesta.remove(0);
                    }
                    cesta.notifyAll();

                    System.out.print(Thread.currentThread().getName()+ ": ");
                    for (Integer i : cesta){
                        System.out.print("\t" + i);
                    }
                    System.out.println();
                }else{
                    try {
                        System.out.println("No hay elementos en la cesta");
                        cesta.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try {
                sleep((int)Math.random()*(2500+1000 +1) +1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
