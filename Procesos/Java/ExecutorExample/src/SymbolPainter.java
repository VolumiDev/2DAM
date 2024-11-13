public class SymbolPainter implements Runnable{

    private final String symbol;

    /**
     *
     * @param symbol Valor que mostrará por pantalla
     */
    public SymbolPainter(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Run this operation.
     * */

    @Override
    public void run() {


        for (int i = 0; i < 5; i++) {
            System.out.print(symbol);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
    }
}
