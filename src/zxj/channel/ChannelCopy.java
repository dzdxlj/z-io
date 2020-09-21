package zxj.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final  int BSIZE = 1024;

    public static void main(String[] args) throws Exception{

        FileChannel in = new RandomAccessFile("C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\2020082001-未发布脚本\\1.SQL","rw").getChannel();
        FileChannel out = new RandomAccessFile("C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\2020082001-未发布脚本\\2.SQL","rw").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        int i = 0;
        out.position(out.size());
        while(in.read(buffer) != -1){
            i++;
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
        in.position(0);
        while(in.read(buffer) != -1){
            i++;
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
        System.out.println(i);
    }
}
