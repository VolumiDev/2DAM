import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

import static java.lang.Thread.sleep;

public class Coche implements Runnable{

    public Coche(int dato) {
        this.dato = dato;
    }

    private int dato;

    @Override
    public void run() {
        int rng = (int)Math.random()*(1000-200+1)+1000;
        try {
            sleep(rng);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Soy el coche "+ dato);
    }
}
