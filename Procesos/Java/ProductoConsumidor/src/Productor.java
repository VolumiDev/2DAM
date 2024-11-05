import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Productor implements Runnable{

    private int cant;
    private final ArrayList<Integer> cesta;

    Productor(ArrayList<Integer> cesta){
        cant = 0;
        this.cesta = cesta;
    }

    public Integer generaUnds(){
        Random rng = new Random();
        int cant = rng.nextInt(1,4);
        return (Integer) cant;
    }

    @Override
    public void run() {
        synchronized (cesta){
            while(true){
                cant = generaUnds();
                if(cesta.size() <10 - cant){
                    for (int i = 0; i < cant ; i++) {
                        cesta.add(0);
                    }
                    cesta.notifyAll();
                }else{
                    System.out.println("La cesta esta llena");
                    try {
                        cesta.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(Thread.currentThread().getName()+ ": ");
                for (Integer i : cesta){
                    System.out.print("\t" + i);
                }
                System.out.println();
                try {
                    sleep((int)Math.random()*(2500-1000 +1) +1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
