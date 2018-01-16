package zh.ffminx.study.java.base;

import java.util.Arrays;
import java.util.Random;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-02 17:23
 */
public class Sort {
    
    /**
     * 快速排序
     *
     * @param array
     * @param low
     * @param high
     */
    private void fastSort(int[] array, int low, int high) {
        int originalLow = low;
        int originalHigh = high;
        if (low >= high) {
            return;
        }
        int key = array[low];
        while (low < high) {
            while (array[high] >= key && high > low) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= key && low < high) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        fastSort(array, originalLow, high - 1);
        fastSort(array, high + 1, originalHigh);
    }
    
    /**
     * 直接插入排序
     *
     * @param array
     */
    private void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            insertSort(array, i);
        }
    }
    
    private void insertSort(int[] array, int index) {
        int key = array[index];
        int i;
        for (i = index - 1; i >= 0; i--) {
            if (array[i] > key) {
                array[i + 1] = array[i];
            } else {
                break;
            }
        }
        array[i + 1] = key;
    }
    
    /**
     * 直接选择排序
     *
     * @param array
     */
    private void selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }
    
    /**
     * 堆排序
     *
     * @param array
     */
    private void heapSort(int[] array) {
        
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
        
    }
    
    private void adjustHeap(int[] array, int root) {
    
    }
    
    
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(100);
        }
        
        Sort sort = new Sort();
        //        sort.fastSort(array, 0, size - 1);
        //        sort.insertSort(array);
        //        sort.selectSort(array);
        sort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
