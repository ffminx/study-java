package zh.ffminx.study.java.jc;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-14 18:03
 */
public class GcTest {
    
    public static void main(String[] args) throws InterruptedException {
        GcTest gcTest = new GcTest();
        System.out.println("main");
        gcTest = null;
        System.gc();
        Thread.sleep(1000 * 30);
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
}
