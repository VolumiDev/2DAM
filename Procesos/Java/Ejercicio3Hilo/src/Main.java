import java.util.ArrayList;
import java.util.List;

public class Main {

    private static ArrayList<Integer> lista;

    public static void showAddition() {
        int total = 0;
        synchronized (lista) {
            for (Integer number : lista) {
                total += number;
            }
            System.out.print("\r El total es de: " + total + " y tiene " + lista.size() + " elementos");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        lista = new ArrayList<Integer>();

        Thread th_integerGenerator = new Thread(new IntegerGenerator(lista));

        th_integerGenerator.start();


        do {
            showAddition();
            Thread.sleep(1000);
        } while (lista.size() <= 100);

    }
}