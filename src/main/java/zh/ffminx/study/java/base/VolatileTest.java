package zh.ffminx.study.java.base;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-11 19:29
 */
public class VolatileTest {
    
    public int num = 0;
    
    public void increment() {
        num++;
    }
    
    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        
        Thread threadThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                test.increment();
            }
        });
        
        threadThread1.start();
        
        try {
            threadThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            test.increment();
        }
        
        System.out.println(test.num);
    }
    
}

