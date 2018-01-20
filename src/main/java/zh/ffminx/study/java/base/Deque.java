package zh.ffminx.study.java.base;

import java.util.ArrayDeque;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-16 20:02
 */
public class Deque {
    
    public static void main(String args[]) {
        java.util.Deque<Integer> q = new ArrayDeque<>();
        //        Deque<Integer> q = new LinkedListTest<>();
        long begin = System.nanoTime();
        test(q);
        long end = System.nanoTime();
        System.out.println("took " + (end - begin) + "ns");
    }
    
    public static void test(java.util.Deque<Integer> q) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                q.addLast(j);
            }
            
            for (int j = 0; j < 10; j++) {
                q.removeFirst();
            }
        }
    }
    
}
