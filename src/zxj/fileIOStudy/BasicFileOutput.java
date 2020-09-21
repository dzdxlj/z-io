package zxj.fileIOStudy;

import java.io.*;

public class BasicFileOutput {

    public static void main(String[] args) throws IOException {
        String fileNAmeme = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\111.txt";
        String fileNAmeIn = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\2020073101-未发布脚本\\02_DATA.SQL";
        File file = new File(fileNAmeme);
        File fileIn = new File(fileNAmeIn);
        System.out.println(file.exists());
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
//        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(BufferedInputFile.read(fileNAmeIn,"GBK"));
        printWriter.flush();
        printWriter.close();
    }

}
