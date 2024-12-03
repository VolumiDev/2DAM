import java.util.concurrent.atomic.AtomicInteger;

public class Main {
        private static AtomicInteger atInt = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        atInt = new AtomicInteger(0);

        Thread thIncrementa = new Thread(new Incremetar(atInt), "HILO INCREMENTA");
        Thread thDecrementa = new Thread(new Decrementar(atInt), "HILO DECREMENTA");
        thIncrementa.start();
        thDecrementa.start();

        thDecrementa.join();
        thIncrementa.join();

        System.out.println("Valor final de: " + atInt);
    }
}