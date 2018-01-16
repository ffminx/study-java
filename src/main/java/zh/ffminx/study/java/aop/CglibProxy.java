package zh.ffminx.study.java.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-12 11:29
 */
public class CglibProxy implements MethodInterceptor {
    
    private Enhancer enhancer = new Enhancer();
    
    public Object getClass(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
    
    public static void main(String[] args) {
        
        CglibProxy proxy = new CglibProxy();
        CglibTarget target = (CglibTarget) proxy.getClass(CglibTarget.class);
        target.say();
    }
    
}
