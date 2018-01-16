package zh.ffminx.study.java.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-25 21:20
 */
public class ArrayListSizeTest {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int initSize = 6;
        for (int i = 0; i < initSize; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        
        initSize = initSize + (initSize >> 1);
        System.out.println(initSize);
    }
    
}
