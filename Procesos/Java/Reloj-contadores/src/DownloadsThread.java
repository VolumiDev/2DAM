import java.util.concurrent.atomic.AtomicInteger;

public class DownloadsThread implements Runnable{

    private AtomicInteger download;

    public DownloadsThread(AtomicInteger downloadValue) {
        download = downloadValue;
    }

    @Override
    public void run() {
        while(download.get() <= 100){
            download.incrementAndGet();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
