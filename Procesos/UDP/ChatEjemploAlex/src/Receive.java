import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {

    DatagramSocket datagramSocket;

    Receive(DatagramSocket ds){
        this.datagramSocket = ds;
    }

    String receiveMessage() throws IOException {
        byte [] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
        System.out.println(packet.getAddress());
        return new String(packet.getData(), 0, packet.getLength());
    }
}
