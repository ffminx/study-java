package zh.ffminx.study.java.threadpool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-14 14:57
 */
public class ScheduleThreadPoolTest {
    
    public static void main(String[] args) throws InterruptedException {
        
        ScheduledExecutorService ses = new ScheduledThreadPoolExecutor(10);
        ses.scheduleAtFixedRate(new Task(1, false), 0, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task(2, true), 0, 3, TimeUnit.SECONDS);
    }
    
    static class Task implements Runnable {
        
        private int id;
        
        private boolean sleepFlag;
        
        public Task(int id, boolean sleepFlag) {
            this.id = id;
            this.sleepFlag = sleepFlag;
        }
        
        @Override
        public void run() {
            System.out.println(id + "..." + Thread.currentThread().toString() + "..." + System.currentTimeMillis());
            if (sleepFlag) {
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
