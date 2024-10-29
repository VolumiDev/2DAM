public class Main {
    static int a = 0, b=0;
    static String cadena = "Esto se hace desde la segunda seccion critica";
    static Object lock = new Object();
    static Object lock_1 = new Object();

    public static void main(String[] args) {
        Thread th1 =new Thread( new IncrementarVariable(), "Thrad-1");
        Thread th2 =new Thread( new IncrementarVariable(), "Thrad-2");
        Thread th3 =new Thread( new IncrementarVariable(), "Thrad-3");
        Thread th4 =new Thread( new IncrementarVariable(), "Thrad-4");


        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }

    static class IncrementarVariable implements Runnable{

         @Override
         public void run() {
             while(true){
                 synchronized (lock){
                     if(a > 50){
                         break;
                     }
                     a++;
                     System.out.println("Valor de a: " +Thread.currentThread().getName() +" " + a);

                     //NOTIFICO AL HILO QUE ESTA A LA ESPARA QUE PUEDE ENTRAR EN LA SECCION CRITICA
                     lock.notify();


                     try {
                             //INFORMO QUE ME PONGO A LA ESPERA Y SALGO DE LA SECCION CRITICA
                             lock.wait();
                         } catch (InterruptedException e) {
                             throw new RuntimeException(e);
                        }
                 }

                 synchronized (lock_1){
                     System.out.println(Thread.currentThread().getName()+": " + cadena);
                     lock_1.notify();
                     try {
                         lock_1.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }
             }
         }
    }
}