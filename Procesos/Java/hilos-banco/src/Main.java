import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int cuenta = 500;
        ReentrantLock lock = new ReentrantLock();
        File txtJane = new File("jane.txt");
        File txtPeter = new File("peter.txt");
        Persona jane = new Persona(cuenta, txtJane, lock);
        Persona peter = new Persona(cuenta, txtPeter, lock);

        Thread theathJane = new Thread(jane, "Jane: ");
        Thread theathPeter = new Thread(peter, "Peter: ");

    }
}