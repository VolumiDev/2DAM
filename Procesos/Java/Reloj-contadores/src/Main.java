import java.time.LocalDateTime;

public class Main {
    public static String clockValue = "Reloj";
    public static String downloadValue = "Descarga";
    public static String countValue = "Reloj";

    public static void main(String[] args) {

        ClockThread clockthread = new ClockThread(clockValue);

        Thread thread1 = new Thread(clockthread, "Reloj");

        thread1.start();


    }
}