package zh.ffminx.study.java.base;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-02 16:12
 */
public class Search {
    
    private boolean findTwo(int target, int[][] array) {
        int m = 0, n = array.length - 1;
        while (n >= 0 && m <= array[0].length - 1) {
            if (array[n][m] > target) {
                n--;
            } else if (array[n][m] < target) {
                m++;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Search search = new Search();
        int target = 7;
        
        int[][] array = new int[][]{new int[]{1, 2, 8, 9}, new int[]{2, 4, 9, 12}, new int[]{4, 7, 10, 13}, new int[]{6, 8, 11, 15}};
        System.out.println(search.findTwo(target, array));
    }
    
}
