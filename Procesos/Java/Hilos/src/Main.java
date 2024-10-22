import javax.swing.text.AsyncBoxView;

public class Main {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("*");
        Hilo h2 = new Hilo("2");

        h1.start();
        h2.start();



        //HiloRunnable hr1 = new HiloRunnable("*");
        //HiloRunnable hr2 = new HiloRunnable("+");
        //HiloRunnable hr3 = new HiloRunnable("1");




        //new Thread(hr1).start();
        //new Thread(hr2).start();
        //new Thread(hr3).start();
    }
}