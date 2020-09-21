package zxj.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        String fileName = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\111.txt";
        FileChannel fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("Some Text".getBytes()));
        fc.close();
        fc = new FileInputStream(fileName).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        buff.rewind();
        String encoding = "Big5";
        System.out.println("输入文件前编码--" +"Decoded using " + encoding + ":" +
                Charset.forName(encoding).decode(buff));
        fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("Some Text2".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream(fileName).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("输入buff前编码--" + buff.asCharBuffer());

        fc = new FileOutputStream(fileName).getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream(fileName).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("通过构建CharBuffer，并使用put方法来保持编码格式--" + buff.asCharBuffer());

    }
}
