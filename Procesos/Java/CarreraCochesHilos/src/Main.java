public class Main {
    public static void main(String[] args) {
        Coche c1 = new Coche(1);
        Coche c2 = new Coche(2);
        Coche c3 = new Coche(3);
        Coche c4 = new Coche(4);
        Coche c5 = new Coche(5);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();
        new Thread(c5).start();
    }
}