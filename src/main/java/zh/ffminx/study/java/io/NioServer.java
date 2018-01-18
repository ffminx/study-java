package zh.ffminx.study.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-11 17:31
 */
public class NioServer {
    
    private static final int PORT = 8888;
    
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int select = selector.select();
                if (select > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        if (next.isAcceptable()) {
                            SocketChannel socketChannel = ((ServerSocketChannel) next.channel()).accept();
                            socketChannel.register(next.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        }
                    }
                }
                Thread.sleep(1000 * 5);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
