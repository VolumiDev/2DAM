import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> cola;
    public static void main(String[] args) {
        cola = new ArrayList<>();

        Thread productor = new Thread(new HiloProductor(cola));
        Thread consumidor = new Thread(new HiloConsumidor(cola));

        productor.start();
        consumidor.start();

    }
}