import java.util.concurrent.locks.ReentrantLock;

public class MainReentratLock {
    public static void main(String[] args) {

        int contador = 0;
        //será el encargado de gestionar la concurrencia
        ReentrantLock lock = new ReentrantLock();

        ThradReentrarLock runnable = new ThradReentrarLock(contador, lock);

        Thread th1 = new Thread(runnable, "Hilo 1");
        Thread th2 = new Thread(runnable, "Hilo 2");
        Thread th3 = new Thread(runnable, "Hilo 3");



    }
}
