import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {

        //OBTENER UN DATAGRAMSOCKET PARA RECIBIR LOS PAQUETES DEL CLIENTE
        DatagramSocket datagramSocket = new DatagramSocket(12345);

        //PREPARAMOS LA INFO

        byte[] buffer = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacket); // EL DATAGRAM SOCKE RECIBE EL PACKET

        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        System.out.println(message);

    }
}
