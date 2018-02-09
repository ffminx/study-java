package zh.ffminx.study.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-24 16:18
 */
public class Boss implements Runnable {
    
    
    private CountDownLatch countDownLatch;
    
    private String bossName;
    
    public Boss(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
        int workerCount = 3;
        CountDownLatch latch = new CountDownLatch(workerCount);
        Worker1 worker11 = new Worker1(latch);
        Worker1 worker12 = new Worker1(latch);
        Worker1 worker13 = new Worker1(latch);
        
        new Thread(worker11).start();
        new Thread(worker12).start();
        new Thread(worker13).start();
    
        Boss boss1 = new Boss(latch);
        Boss boss2 = new Boss(latch);
    
        new Thread(boss1).start();
        new Thread(boss2).start();
    }
    
    @Override
    public void run() {
        this.bossName = Thread.currentThread().toString();
        System.out.println("boss:" + this.bossName + " wait...");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("boss:" + this.bossName + " continue");
    }
    
}
