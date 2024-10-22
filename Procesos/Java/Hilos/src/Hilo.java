public class Hilo extends Thread{
    private String dato;

    public Hilo(String dato) {
        this.dato = dato;
    }

    @Override
    public void run() {
        while(true){
            System.out.print(dato);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
