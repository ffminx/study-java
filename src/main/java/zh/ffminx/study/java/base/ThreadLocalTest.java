package zh.ffminx.study.java.base;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-25 10:18
 */
public class ThreadLocalTest {
    
    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();
    
    private static final ThreadLocal<Integer> THREAD_LOCAL_2 = new InheritableThreadLocal<>();
    
    public static void main(String[] args) throws InterruptedException {
        
        THREAD_LOCAL.set(100);
        THREAD_LOCAL_2.set(200);
        
        Thread t = new Thread(() -> {
            System.out.println(THREAD_LOCAL.get());
            System.out.println(THREAD_LOCAL_2.get());
            
            THREAD_LOCAL_2.set(300);
            
            System.out.println(THREAD_LOCAL_2.get());
        });
        
        t.start();
        
        t.join();
        
        System.out.println(THREAD_LOCAL.get());
        System.out.println(THREAD_LOCAL_2.get());
    }
    
}
