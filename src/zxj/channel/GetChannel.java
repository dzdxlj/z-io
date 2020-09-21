package zxj.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * @ Description   :  FileInputStream,FileOutputStream,RandomAccessFile
 * 调换这个buffer的当前位置，并且设置当前位置是0。说的意思就是：
 * 将缓存字节数组的指针设置为数组的开始序列即数组下标0。这样就可以从buffer开头，
 * 对该buffer进行遍历（读取）了。
 *  buffer中的flip方法涉及到bufer中的Capacity,Position和Limit三个概念。
 *  其中Capacity在读写模式下都是固定的，就是我们分配的缓冲大小,Position类似于读写指针，
 *  表示当前读(写)到什么位置,Limit在写模式下表示最多能写入多少数据，此时和Capacity相同，
 *  在读模式下表示最多能读多少数据，此时和缓存中的实际数据大小相同。在写模式下调用flip方法，
 *  那么limit就设置为了position当前的值(即当前写了多少数据),postion会被置为0，
 *  以表示读操作从缓存的头开始读。也就是说调用flip之后，读写指针指到缓存头部，
 *  并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
 * @ Author        : zxj
 * @ CreateDate    :  2020/9/1 20:40
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        //普通的管道
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());   //将当前位置移动到文件的最末端
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc = new FileInputStream("").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
    }
}
