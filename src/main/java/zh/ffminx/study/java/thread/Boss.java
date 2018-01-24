package zh.ffminx.study.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-24 16:18
 */
public class Boss {
    
    public static void main(String[] args) throws InterruptedException {
        int workerCount = 3;
        CountDownLatch latch = new CountDownLatch(workerCount);
        Worker1 worker11 = new Worker1(latch);
        Worker1 worker12 = new Worker1(latch);
        Worker1 worker13 = new Worker1(latch);
        
        new Thread(worker11).start();
        new Thread(worker12).start();
        new Thread(worker13).start();
        
        latch.await();
        System.out.println("all worker complete work, boss begin checking");
    }
    
}
