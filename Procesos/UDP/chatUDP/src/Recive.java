//ACTUA COMO SERVIDOR

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Recive {

    DatagramSocket ds;

        Recive(DatagramSocket datagramSocket){
            ds = datagramSocket;
        }


        String reciveMessage() throws IOException {
            byte[] buffer = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            ds.receive(datagramPacket);

            return new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        }
}
