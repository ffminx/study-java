package zh.ffminx.study.java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-03 12:55
 */
public class Channel {
    
    private void testFileChannel() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/FFMinX/.zshrc", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (channel.read(buffer) != 1) {
        
        }
        
        System.out.println(buffer.toString());
    }
    
    public static void main(String[] args) throws IOException {
        Channel channel = new Channel();
        channel.testFileChannel();
    }
    
}
