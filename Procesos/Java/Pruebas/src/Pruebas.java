import java.io.IOException;

public class Pruebas {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
        Process p;
        try {
             p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p.waitFor();
        System.out.println("cerrado");

    }
}
