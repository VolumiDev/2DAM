import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Person2 {
    public static void main(String[] args) throws IOException {

        int myPort = 12346; // Puerto para recibir
        int targetPort = 12345; // Puerto dónde queremos enviar
        InetAddress targetAddress = InetAddress.getByName("127.31.31.31");

        DatagramSocket socket = new DatagramSocket(myPort);

        Send sender = new Send(socket, targetAddress, targetPort);
        Receive receiver = new Receive(socket);

        Thread receiveThread = new Thread(() -> {
            try {
                while (true) {
                    String message = receiver.receiveMessage();
                    System.out.println("Recibido: " + message);

                    if (message.equalsIgnoreCase("exit")) {
                        System.out.println("Chat finalizado.");
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        });

        Thread sendThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String message = scanner.nextLine();
                    sender.sendMessage(message);
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        });

        receiveThread.start();
        sendThread.start();

        try {
            receiveThread.join();
            sendThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error en la ejecución de los hilos: " + e.getMessage());
        }

        // Cerramos el socket. IMPORTANTE
        socket.close();
        System.out.println("Chat finalizado.");
    }
}
