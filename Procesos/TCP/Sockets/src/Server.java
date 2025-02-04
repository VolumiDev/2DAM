import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // CREAMOS EL SERVIDOR CON LA BIBLIOTACA .NET
        ServerSocket serverSocket = new ServerSocket(43210);
        // CRAMOS UN SOCKET A EL QUE ASIGNAMOS EL SERVIDOR
            //EL ACCEP QUEDA A LA ESPERA HASTA QUE SE RECIBE LA INFORMACION
        Socket socket = serverSocket.accept();

        //CREAMOS EL DATA INPUT STREAM PARA RECIBIR EL DATO
        while(true){
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println(dataInputStream.readUTF());

            Scanner scanner = new Scanner(System.in);
            dataOutputStream.writeUTF(scanner.nextLine());
        }

    }
}
