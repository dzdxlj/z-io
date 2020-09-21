package zxj.fileIOStudy;

import java.io.*;

public class BufferedInputFile {
    public static String read(String path,String encoding) throws IOException {
        File file = new File(path);
        if(file.exists()){
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String register = "";
            StringBuilder result = new StringBuilder();
            while((register = bufferedReader.readLine()) != null){
                result.append(register + "\n");
            }
            bufferedReader.close();
            return result.toString();
        }else{
            return "";
        }
    }

    /**
     * 判断文件的编码格式
     * @param fileName :file
     * @return 文件编码格式
     * @throws Exception
     */
    public static String codeString(String fileName) throws Exception{
        File file = new File(fileName);
        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(file));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        bin.close();
        return code;
    }

    public static void main(String[] args) {
        String fileNAme = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\2020073101-未发布脚本\\02_DATA.SQL";
        try {
            System.out.println(read(fileNAme,codeString(fileNAme)));
            System.out.println(codeString(fileNAme));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
