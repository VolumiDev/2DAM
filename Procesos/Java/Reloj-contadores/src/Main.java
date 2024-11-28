import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static  StringBuilder clockValue = new StringBuilder("");
    public static AtomicInteger downloadValue = new AtomicInteger(0);
    public static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        ClockThread clockthread = new ClockThread(clockValue);
        CounterThread countThread = new CounterThread(count);
        DownloadsThread downloadsThread = new DownloadsThread(downloadValue);

        Thread thread1 = new Thread(clockthread, "Reloj");
        Thread thread2 = new Thread(countThread, "Contador");
        Thread thread3 = new Thread(downloadsThread, "Descarga");

        thread1.start();
        thread2.start();
        thread3.start();

        while (true) {

            System.out.print("\rReloj: " + clockValue + "cuenta: " + count + " Paquete: " + downloadValue+ "/100");
            Thread.sleep(1000);
        }
    }



}