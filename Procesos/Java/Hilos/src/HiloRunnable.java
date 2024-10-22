public class HiloRunnable implements Runnable{

    private String dato;

    public HiloRunnable(String dato) {
        this.dato = dato;
    }

    @Override
    public void run() {
        while(true){
            System.out.print(dato);
        }
    }
}
