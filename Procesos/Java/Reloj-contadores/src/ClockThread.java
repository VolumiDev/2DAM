import java.time.LocalDateTime;

public class ClockThread implements Runnable{

    private LocalDateTime date;
    static StringBuilder showClock;

    public ClockThread(StringBuilder showClock) {
        this.showClock = showClock;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while(true){
            date = LocalDateTime.now();
            showClock.setLength(0);
            showClock.append(date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() +" ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
