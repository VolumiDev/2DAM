import java.util.ArrayList;

public class Bank {
    private static ArrayList<Sucursal> sucursales;

    Bank(){
        sucursales = new ArrayList<Sucursal>();
        for (int i = 0; i < 4; i++) {
            Sucursal s = new Sucursal();
            sucursales.add(s);
        }

    }

    public static ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public static void setSucursales(ArrayList<Sucursal> sucursales) {
        Bank.sucursales = sucursales;
    }
}
