import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        /*
        *   en este caso le hemos pasado una docena de hilos para que los gestione.
        * */
        executor.submit(new SymbolPainter("*"));
        executor.submit(new SymbolPainter("+"));
        executor.submit(new SymbolPainter("$"));
        executor.submit(new SymbolPainter("%"));
        executor.submit(new SymbolPainter("&"));
        executor.submit(new SymbolPainter("@"));
        executor.submit(new SymbolPainter("{"));
        executor.submit(new SymbolPainter("}"));
        executor.submit(new SymbolPainter("¡"));
        executor.submit(new SymbolPainter("?"));
        executor.submit(new SymbolPainter("/"));

        // cuado termine, terminará
        executor.shutdown();


    }
}