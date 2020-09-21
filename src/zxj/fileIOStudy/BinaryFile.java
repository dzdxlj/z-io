package zxj.fileIOStudy;

import java.io.*;

public class BinaryFile {
    public static byte[] read(File bfile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bfile));
        try{
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }
}
