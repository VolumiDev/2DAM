public class Main {
    private static volatile Bank banco;


    public static void main(String[] args) {
        banco = new Bank();

        Thread c1 = new Thread(new HiloCliente(banco,0), "Cliente 1:");
        Thread c2 = new Thread(new HiloCliente(banco,1), "Cliente 2:");
        Thread c3 = new Thread(new HiloCliente(banco,2), "Cliente 3:");
        Thread c4 = new Thread(new HiloCliente(banco,3), "Cliente 4:");


        c1.start();
        c2.start();
        c3.start();
        c4.start();

    }

    public static Bank getBanco() {
        return banco;
    }

    public static void setBanco(Bank banco) {
        Main.banco = banco;
    }
}