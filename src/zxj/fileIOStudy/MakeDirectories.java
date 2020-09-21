package zxj.fileIOStudy;

import java.io.File;

public class MakeDirectories {
    private static void usage(){
        System.err.println("这是一个输出报错的信息");
        System.exit(1);
    }

    public static void main(String[] args) {
        File s = new File("ss/aa");
        System.out.println(s.getAbsolutePath());
        System.out.println(s.exists());
        if(!s.exists()){
            try {
//                s.createNewFile();
                boolean mkdir = s.mkdirs();
                System.out.println(mkdir);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
