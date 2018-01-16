package zh.ffminx.study.java.base;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-12 20:35
 */
public class ByteToLong {
    
    public static void main(String[] args) {
        byte[] bytes = new byte[]{0x23, 0x32};
        System.out.println(getLong(bytes, 0, bytes.length));
    }
    
    public static long getLong(byte[] bytes, int index, int length) {
        long result = 0;
        for (int i = index + length - 1, j = 0; i >= index && j <= 56; i--, j = j + 8) {
            result |= (long) (bytes[i] & 0xff) << j;
        }
        return result;
    }
    
    
}
