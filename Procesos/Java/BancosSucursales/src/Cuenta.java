import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class Cuenta {
    private AtomicInteger saldo;


    public void añadirSaldo() throws InterruptedException {
        synchronized (saldo) {
            int cantidad = RandomGenerator.getDefault().nextInt(100,2000);
            saldo.set(cantidad);
            System.out.println(Thread.currentThread().getName() +  " ingreso "+ cantidad + " hay:-------"+ saldo + "€");
            Main.getBanco().notifyAll();
        }
        Thread.sleep(RandomGenerator.getDefault().nextInt(100,700));
    }

    public void retirarSaldo() throws InterruptedException {
        int cantidad = RandomGenerator.getDefault().nextInt(20,1000);
        synchronized (saldo){
            if (cantidad > saldo.get()) {
                System.out.println(Thread.currentThread().getName() + " NO PUEDE SACAR SALDO INSUFICIENTE ##" + Thread.currentThread().getName() + "## ESPERA");
                Main.getBanco().wait();
            }
            saldo.set(saldo.get() - cantidad);
            System.out.println(Thread.currentThread().getName() + " retiro "+ cantidad + " quedan:-------"+ saldo + "€");
            Main.getBanco().notifyAll();
        }
        Thread.sleep(RandomGenerator.getDefault().nextInt(100,700));
    }

    public AtomicInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(AtomicInteger saldo) {
        this.saldo = saldo;
    }
}
