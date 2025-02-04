import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {

    DatagramSocket datagramSocket;
    InetAddress ip;
    int port;

    Send (DatagramSocket ds, InetAddress ip, int port){
        this.datagramSocket = ds;
        this.ip = ip;
        this.port = port;
    }

    void sendMessage(String message) throws IOException {

        byte [] buffer = message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, ip, port);

        datagramSocket.send(datagramPacket);
    }
}
