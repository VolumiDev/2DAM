import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.concurrent.locks.ReentrantLock;

public class Persona implements Runnable{


    /**
     * Runs this operation.
     */

    private final int cuenta;
    private File movimientos;
    private final ReentrantLock lock;

    public Persona(int saldo, File txt, ReentrantLock lock) {
        this.cuenta = saldo;
        this.movimientos = txt;
        this.lock = lock;
    }

    @Override
    public void run() {
        FileReader fr = new FileReader(movimientos);
        BufferedReader br = new BufferedReader(fr);
    }
}
