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
            int key = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > key) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }
    
    private void shellSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int gap = array.length >> 1;
        while (gap > 0) {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                int j;
                for (j = i; j > gap; j -= gap) {
                    if (array[j - gap] > key) {
                        array[j] = array[j - gap];
                    } else {
                        break;
                    }
                }
                array[j + gap] = key;
            }
            gap = gap >> 1;
        }
        
        //        if(arr == null || arr.length <= 1) return;
        //        int gap=arr.length/2;
        //        while(gap>0){
        //            for(int i=1;i<arr.length ;i++){
        //                int temp=arr[i];
        //                int p=i;
        //                while(p>=gap&&arr[p-gap]>temp){
        //                    arr[p]=arr[p-gap];
        //                    p-=gap;
        //                }
        //                arr[p]=temp;
        //            }
        //            gap/=2;
        //        }
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
        sort.shellSort(array);
        //        sort.selectSort(array);
        //        sort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
