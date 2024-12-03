import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class Sucursal {
    private static ArrayList<Cuenta> cuentas;

    Sucursal(){
        cuentas = new ArrayList<Cuenta>();
    }

    public void addCuenta(int cantidad) throws InterruptedException {
        Cuenta c = new Cuenta();
        synchronized (cuentas) {
            c.setSaldo(new AtomicInteger(cantidad));
            cuentas.add(c);
            System.out.println(Thread.currentThread().getName() + "CUENTA CREADA");
            Main.getBanco().notifyAll();
            Thread.sleep(RandomGenerator.getDefault().nextInt(500, 700));
        }
    }

    public void remCuenta() throws InterruptedException {

        synchronized (cuentas) {
            if (cuentas.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "NO HAY CUENTAS QUE BORRAR, ##"+ Thread.currentThread().getName() +"## ESPERAMOS");
                Main.getBanco().wait();
            }
            int randIndex = RandomGenerator.getDefault().nextInt(cuentas.size());
            cuentas.remove(randIndex);
            System.out.println(Thread.currentThread() + "CUENTA BORRADA");
            Main.getBanco().notifyAll();
        }
        Thread.sleep(RandomGenerator.getDefault().nextInt(500, 700));
    }

    public void retirarDienero() throws InterruptedException {
        synchronized (cuentas){
            if(cuentas.size() == 0){
                System.out.println(Thread.currentThread().getName() + "NO HAY CUENTAS DE LAS QUE SACAR DINERO, "+ Thread.currentThread().getName() +" ESPERAMOS");
                Main.getBanco().wait();
            }
            int randIndex = RandomGenerator.getDefault().nextInt(cuentas.size());
            cuentas.get(randIndex).retirarSaldo();
        }
    }

    public void ingresarDienero() throws InterruptedException {
        synchronized (cuentas){
            if(cuentas.size() == 0){
                System.out.println(Thread.currentThread().getName() + "NO HAY CUENTAS A LAS QUE METER DINERO, "+ Thread.currentThread().getName() +" ESPERAMOS");
                Main.getBanco().wait();
            }
            int randIndex = RandomGenerator.getDefault().nextInt(cuentas.size());
            cuentas.get(randIndex).añadirSaldo();
        }
    }

    public static ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public static void setCuentas(ArrayList<Cuenta> cuentas) {
        Sucursal.cuentas = cuentas;
    }
}
