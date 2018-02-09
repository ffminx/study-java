package zh.ffminx.study.java.base;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.Arrays;
import java.util.Random;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-02-01 17:17
 */
public class Sort {
    
    public static void main(String[] args) {
        int max = 50;
        int size = 100;
        Random random = new Random();
        int[] array = random.ints(0, max).limit(size).toArray();
        System.out.println(Arrays.toString(array));
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Sort.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            long beginTime = System.nanoTime();
            Object o = proxy.invokeSuper(obj, args1);
            long endTime = System.nanoTime();
            System.out.println("cost time:" + (endTime - beginTime));
            return o;
        });
        Sort sort = (Sort) enhancer.create();
        sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    public void bubbleSort2(int[] array) {
        int flag = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }
    
    public void bubbleSort3(int[] array) {
        int n = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            int loc = n;
            for (int j = 0; j < loc; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    n = j;
                }
            }
            if (n == loc) {
                break;
            }
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
}
