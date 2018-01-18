package zh.ffminx.study.java.base;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-18 19:00
 */
public class Extends extends A {
    
    static {
        System.out.println("Extends static");
    }
    
    Extends() {
        System.out.println("Extends");
    }
    
    {
        System.out.println("Extends field");
    }
    
    public static void main(String[] args) {
        
        new Extends();
        
        new A();
    }
    
    
}

class A {
    static {
        System.out.println("A static");
    }
    
    {
        System.out.println("A field");
    }
    
    A() {
        System.out.println("A");
    }
}
