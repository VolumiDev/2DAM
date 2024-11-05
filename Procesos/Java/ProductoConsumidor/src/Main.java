import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Object lock = new Object();
        ArrayList<Integer> cesta = new ArrayList<Integer>();


        Thread hiloConsumidor = new Thread(new Consumidor(cesta), "consumidor");
        Thread hiloProductor = new Thread(new Productor(cesta), "productor");

        hiloProductor.start();
        hiloConsumidor.start();
    }
}