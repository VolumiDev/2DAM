import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Send {

    DatagramSocket ds;
    String ip;
    int port;

    Send(DatagramSocket datagramSocket, String ip ){
        this.ds = datagramSocket;
        this.ip = ip;
        this.port = port;
    }


    void sendMessage(String mess) throws IOException {
        byte[] buffer = mess.getBytes();

        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

        ds.send(dp);



    }


}
