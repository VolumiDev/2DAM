import java.net.DatagramSocket;
import java.net.SocketException;

public class Persona1 {

    public static void main(String[] args) throws SocketException {
        DatagramSocket ds = new DatagramSocket(12345);

        Send sender = new Send(ds, "127.0.0.1");
        Recive receiver = new Recive(ds);

        Thread receiveThread = new Thread(() -> {
           //Incluimos el codigo de los hilos


        });


        Thread senderThread = new Thread(() -> {
            //Incluimos el codigo de los hilos



        });

        //SE INICIALIZAN LOS HILOS ENCARGADOS DE RECIBIR O ENVIAR
        receiveThread.start();
        senderThread.start();

    }
}
