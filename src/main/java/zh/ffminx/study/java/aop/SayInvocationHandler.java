package zh.ffminx.study.java.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-12 11:41
 */
public class SayInvocationHandler implements InvocationHandler {
    
    private Object targetObject;
    
    public Object getProxyObject(Object object) {
        this.targetObject = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(targetObject, args);
        System.out.println("after");
        return result;
    }
    
    public static void main(String[] args) {
        Say proxyObject = (Say) new SayInvocationHandler().getProxyObject(new CglibTarget());
        proxyObject.say();
    }
    
}
