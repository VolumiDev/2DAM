public class HiloRunnable implements Runnable{

    private int[] numArr;
    private String nombre;
    private int posInit, posFin;

    public HiloRunnable( String nombre,int[] arr,  int posInicial, int posFinal) {
        this.numArr = arr;
        this.nombre = nombre;
        this.posInit = posInicial;
        this.posFin = posFinal;
    }

    int numFinal;



    @Override
    public void run() {
        int sum = 0;
        long initTime = System.currentTimeMillis();
        System.out.println(initTime);
        for (int i = posInit; i < posFin ; i++) {
            sum += numArr[i];
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Hilo " + nombre + "tardo: " + (finishTime - initTime));
    }
}
