package zh.ffminx.study.java.base;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-17 11:08
 */
public class CharsetTest {
    
    public static void main(String args[]) {
        byte[] b = {-26, -75, -73};
        ByteBuffer bb = ByteBuffer.allocate(3);
        bb.put(b, 0, 3);
        bb.flip();
        CharBuffer cb = UTF_8.decode(bb);
        char c = cb.charAt(0);
        System.out.println(c);
        
        char a1 = '中';
        char b1 = 0x4e2d;
        char c1 = 20013;
        System.out.println(a1);
        System.out.println(b1 + "--->" + (int) b1);
        System.out.println(c1);
        
        System.out.println(Charset.availableCharsets().toString());
    }
}
