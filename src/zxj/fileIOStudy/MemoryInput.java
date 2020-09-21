package zxj.fileIOStudy;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {


    public static void main(String[] args) throws IOException {
        String fileNAme = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\2020073101-未发布脚本\\02_DATA.SQL";
        StringReader in = new StringReader(BufferedInputFile.read(fileNAme,"GBK"));
        int c;
        while((c = in.read()) != -1){
//            System.out.print(c);
            System.out.print((char)c);
        }
        in.close();
    }
}
