public class Main {
    public static void main(String[] args) {
        int[] arrNum = new int[1000000];
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = i;
        }


        HiloRunnable th1 = new HiloRunnable("primero ",arrNum, 0, 250000);
        HiloRunnable th2 = new HiloRunnable("segundo ",arrNum, 250000, 500000);
        HiloRunnable th3 = new HiloRunnable("tercero ",arrNum, 500000, 750000);
        HiloRunnable th4 = new HiloRunnable("cuarto ",arrNum, 750000, 1000000);



        long groupInitTime = System.currentTimeMillis();
        new Thread(th1).start();
        new Thread(th2).start();
        new Thread(th3).start();
        new Thread(th4).start();

        int sum=0;
        long initTime = System.currentTimeMillis();
        for (int i = 0; i < arrNum.length; i++) {
            sum += arrNum[i];
        }
        long finishTime = System.currentTimeMillis();

        System.out.println("Mono hilo tardo: " +  (finishTime - initTime));
    }
}