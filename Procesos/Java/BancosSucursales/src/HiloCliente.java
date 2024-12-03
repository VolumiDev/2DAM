import java.util.Random;
import java.util.random.RandomGenerator;

public class HiloCliente implements Runnable {

    private static Bank banco;
    private int primeraSucursal;

    public HiloCliente(Bank banco, int sucursal) {
        this.banco = banco;
        this.primeraSucursal = sucursal;
    }

    @Override
    public void run() {
        synchronized (banco) {
            try {
                banco.getSucursales().get(primeraSucursal).addCuenta(RandomGenerator.getDefault().nextInt(100, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (true) {
            int accesoAccion = RandomGenerator.getDefault().nextInt(4);

            synchronized (banco) {
                int accesoSucursal = RandomGenerator.getDefault().nextInt(banco.getSucursales().size());
                switch (accesoAccion){
                    case 0:
                        try {
                            banco.getSucursales().get(accesoSucursal).addCuenta(RandomGenerator.getDefault().nextInt(100,1000));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;

                    case 1:
                        try {
                            banco.getSucursales().get(accesoSucursal).remCuenta();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;

                    case 2:
                        try {
                            banco.getSucursales().get(accesoSucursal).ingresarDienero();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;

                    case 3:
                        try {
                            banco.getSucursales().get(accesoSucursal).retirarDienero();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
            }
        }

    }


}
