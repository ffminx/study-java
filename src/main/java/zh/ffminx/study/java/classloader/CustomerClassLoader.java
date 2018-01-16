package zh.ffminx.study.java.classloader;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-12 19:27
 */
public class CustomerClassLoader {
    
    public static void main(String[] args) {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader();
        customerClassLoader.printClassLoader();
    }
    
    public void printClassLoader() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
    }
    
}
