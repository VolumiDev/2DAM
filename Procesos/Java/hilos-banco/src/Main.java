import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static int cuenta = 500;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        File txtJane = new File("jane.txt");
        File txtPeter = new File("peter.txt");
        Persona jane = new Persona(txtJane, lock);
        Persona peter = new Persona(txtPeter, lock);

        Thread thJane = new Thread(jane, "Jane: ");
        Thread thPeter = new Thread(peter, "Peter: ");

        thJane.start();
        thPeter.start();

        thPeter.join();
        thJane.join();

    }
}