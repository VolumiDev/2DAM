import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Persona implements Runnable{


    /**
     * Runs this operation.
     */

    private File movimientos;
    private final ReentrantLock lock;

    public Persona(File txt, ReentrantLock lock) {
        this.movimientos = txt;
        this.lock = lock;
    }

    @Override
    public void run() {

        Random rnd = new Random();
        boolean flag = false;
        int retira = 0;
        try {
        FileReader fr = new FileReader(movimientos);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        while(linea != null){
            int rng = rnd.nextInt(1000)+500;
            lock.lock();
            flag = true;


            if(linea.contains("-")) {
                retira = Integer.parseInt(linea.split("-")[1].trim());
                do{
                    if (retira <= Main.cuenta) {
                        Main.cuenta -= retira;
                        Thread.sleep(rng);
                        System.out.println(Thread.currentThread().getName() + " retira " + retira + " Quedan " + Main.cuenta);
                        flag = false;
                    } else {

                        System.err.println("No puede retirar esa cantidad");
                        lock.unlock();
                    }
                }while(flag);


            }else {
                retira = Integer.parseInt(linea.trim());
                Main.cuenta += retira;

                Thread.sleep(rng);
                System.out.println(Thread.currentThread().getName() + " ingresa " + retira + " Quedan " + Main.cuenta);

            }
            linea = br.readLine();

            lock.unlock();
        }
        br.close();
        fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
