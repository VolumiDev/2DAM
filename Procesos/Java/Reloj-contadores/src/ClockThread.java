import java.time.LocalDateTime;
import java.util.Date;

public class ClockThread implements Runnable{

    private LocalDateTime date;
    private String showClock;

    public ClockThread(String clock) {

    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while(true){

            date = LocalDateTime.now();

             date.getHour() + ":" + date.getMinute() + ":" + date.getSecond();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
