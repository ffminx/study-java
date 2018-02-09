package zh.ffminx.study.java.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-24 16:16
 */
public class Worker2 implements Runnable {
    
    private CyclicBarrier barrier;
    
    private String workName;
    
    public Worker2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    
    @Override
    public void run() {
        this.workName = Thread.currentThread().toString();
        
        System.out.println("worker:" + workName + " begin to project 1");
        
        try {
            Thread.sleep(new Random().nextInt(20) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("worker:" + workName + " complete project 1");
        
        try {
            int await = barrier.await();
            System.out.println("worker: " + workName + " await: " + await);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        
        System.out.println("woker:" + workName + " begin to project 2");
    }
    
    public static void main(String[] args) {
        int workerSize = 3;
        CyclicBarrier barrier = new CyclicBarrier(workerSize, new Runnable() {
            @Override
            public void run() {
                System.out.println("main thread statue:" + Thread.currentThread().getState());
                System.out.println(Thread.currentThread() + " ---> 111");
            }
        });
        Worker2 worker1 = new Worker2(barrier);
        Worker2 worker2 = new Worker2(barrier);
        Worker2 worker3 = new Worker2(barrier);
        new Thread(worker1).start();
        new Thread(worker2).start();
        new Thread(worker3).start();
        System.out.println("main thread statue:" + Thread.currentThread().getState());
    }
    
}
