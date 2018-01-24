package zh.ffminx.study.java.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-24 16:16
 */
public class Worker1 implements Runnable {
    
    private CountDownLatch latch;
    
    private String workName;
    
    public Worker1(CountDownLatch latch) {
        this.latch = latch;
    }
    
    @Override
    public void run() {
        this.workName = Thread.currentThread().getName();
        System.out.println("worker:" + workName + " begin work");
        Integer workTime = new Random().nextInt(20);
        try {
            Thread.sleep(1000 * workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("worker:" + workName + " complete work");
        latch.countDown();
    }
    
}
