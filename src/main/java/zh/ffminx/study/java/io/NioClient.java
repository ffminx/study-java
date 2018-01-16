package zh.ffminx.study.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-11 17:36
 */
public class NioClient {
    
    private static final int PORT = 8888;
    
    
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            boolean connect = socketChannel.connect(new InetSocketAddress(PORT));
            System.out.println(connect);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
