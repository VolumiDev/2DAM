import java.io.IOException;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws IOException {

        //OBTENER UN DATAGRAMSOCKET PARA RECIBIR LOS PAQUETES DEL CLIENTE
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] buffer = "Hola Diego".getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 12345);


        datagramSocket.send(datagramPacket);


    }
}
