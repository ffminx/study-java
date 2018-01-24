package zh.ffminx.study.java.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-23 19:46
 */
public class SortTest {
    
    public void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int m = 0; m < i; m++) {
                if (array[m + 1] < array[m]) {
                    swap(array, m, m + 1);
                }
            }
        }
    }
    
    public void bubbleSort2(int[] array) {
        int beginIndex = 0;
        int endIndex = array.length - 1;
        for (int i = beginIndex; i <= endIndex; i++) {
            int minIndex = beginIndex;
            for (int m = i; m < endIndex; m++) {
                if (array[m + 1] < array[m]) {
                    swap(array, m, m + 1);
                }
                if (array[m] < array[minIndex]) {
                    minIndex = m;
                }
            }
            if (minIndex != beginIndex) {
                swap(array, beginIndex, minIndex);
            }
            beginIndex++;
            endIndex--;
        }
    }
    
    public void numberSort(int[] array) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        int[] tmp = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            tmp[array[i] - min]++;
        }
        int[] result = new int[array.length];
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i]; j++) {
                result[index] = i + min;
                index++;
            }
        }
        System.arraycopy(result, 0, array, 0, result.length);
    }
    
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(size * 5);
        }
        System.out.println(Arrays.toString(array));
        SortTest test = new SortTest();
        test.numberSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
