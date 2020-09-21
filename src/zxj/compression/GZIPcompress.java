package zxj.compression;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\zhangxiaojun\\Desktop\\02_Source\\02_Source\\01_Source\\fms-branch\\WebContent\\static\\app\\fms\\mf\\generalOrderQueryManage.js"));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("C:\\Users\\zhangxiaojun\\Desktop\\02_Source\\02_Source\\01_Source\\fms-branch\\WebContent\\static\\app\\fms\\mf\\generalOrderQueryManage.gz")));
        System.out.println("Write file");
        int c;
        while((c = in.read()) != -1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("C:\\Users\\zhangxiaojun\\Desktop\\02_Source\\02_Source\\01_Source\\fms-branch\\WebContent\\static\\app\\fms\\mf\\generalOrderQueryManage.gz")),"UTF-8"));
        String s;
        while((s = in2.readLine()) != null){
            System.out.println(s);
        }
        in2.close();
    }
}
