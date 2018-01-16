package zh.ffminx.study.java.base;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-09 15:19
 */
public class KMP {
    
    private static int count = 0;
    
    private static int kmp(String str, String dest, int[] next) {//str文本串  dest 模式串
        int i = 0, j = 0;
        char[] src = str.toCharArray();
        char[] ptn = dest.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        while (i < sLen && j < pLen) {
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen)
            count++;
        return 0;
    }
    
    private static int[] kmpnext(String dest) {
        char[] p = dest.toCharArray();
        int pLen = p.length;
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
    
    public static void main(String[] args) {
        String a = "ssdf";
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);
        kmp(b, a, next);
        System.out.println(count);
    }
    
}
