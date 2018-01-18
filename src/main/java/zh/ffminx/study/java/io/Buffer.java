package zh.ffminx.study.java.io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-18 11:25
 */
public class Buffer {
    
    public static void main(String[] args) {
        
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.position());
        intBuffer.flip();
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        
        
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer1.equals(byteBuffer2));
        System.out.println(byteBuffer1.compareTo(byteBuffer2));
        System.out.println(byteBuffer1.position());
        System.out.println(byteBuffer1.get());
        System.out.println(byteBuffer1.position());
    }
    
    
}
