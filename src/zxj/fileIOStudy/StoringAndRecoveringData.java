package zxj.fileIOStudy;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws Exception {
        String fileName = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\2020073101-未发布脚本\\02_DATA.SQL";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(fileName)
        ));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(fileName)
        ));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(BufferedInputFile.codeString(fileName));
    }
}
