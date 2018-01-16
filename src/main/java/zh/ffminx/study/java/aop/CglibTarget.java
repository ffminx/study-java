package zh.ffminx.study.java.aop;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-12 11:29
 */
public class CglibTarget implements Say {
    
    @Override
    public void say() {
        System.out.println("this is target");
    }
    
}
