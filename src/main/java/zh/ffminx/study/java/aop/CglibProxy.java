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
    
    private Object targetObject;
    
    public Object getClass(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    public Object getProxyObject(Object object) {
        this.targetObject = object;
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    
    @Override
    public Object intercept(Object proxyObject, Method originalMethod, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        if (originalMethod.getName().contains("say")) {
            System.out.println(proxyObject.toString());  // stack over flow!!!
        }
        System.out.println(originalMethod.toString());
        System.out.println(methodProxy.toString());
        System.out.println("before");
    
        //        Object result = methodProxy.invokeSuper(o, objects);
        //        Object result = originalMethod.invoke(this.targetObject, objects);
        Object result = methodProxy.invoke(this.targetObject, objects);
        System.out.println("after");
        return result;
    }
    
    public static void main(String[] args) {
        
        CglibProxy proxy = new CglibProxy();
        //        CglibTarget target = (CglibTarget) proxy.getClass(CglibTarget.class);
        CglibTarget target = new CglibTarget();
        CglibTarget proxyObject = (CglibTarget) proxy.getProxyObject(target);
        proxyObject.say();
    }
    
}
