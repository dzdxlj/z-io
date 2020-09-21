package zxj.channel;

import java.nio.ByteBuffer;

public class GetData {
    private static final  int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while(i++ < bb.limit()){
            /**
              get方法可以获取当前ByteBuffer所在的位置的值，并将位置下移动一位
              get(i)方法则是获取i位置的值,不移动当前位置到哪里
             这边这个方法是为了验证ByteBuffer是不是空的
             */
            if(bb.get() != 0){
                System.out.print("nonzero");
            }
        }
        System.out.println("i = " + i);
        bb.rewind();

        bb.asCharBuffer().put("Howdy");
        char c;
        while((c = bb.getChar()) != 0){
            System.out.print(c + "");
        }
        System.out.println();

        bb.asShortBuffer().put((short)47);
        System.out.print(bb.getShort());
        bb.rewind();
        /**
         * 下面同样格式可以有asIntBuffer,asLongBuffer,asFloatBuffer,asDoubleBuffer
         */
    }
}
