package zxj.file;

import zxj.fileIOStudy.BufferedInputFile;
import zxj.fileIOStudy.FileTreeInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class getTableSqlFile {

    public static void main(String[] args) {
        String fileNAmeme = "C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本\\111.txt";
        File file = new File("C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本"); //获得指定路径
        FileTreeInfo fileTreeInfo = FileTreeInfo.walk(file, ".*TABLE.*");
        List<File> files = fileTreeInfo.files;
        for (File temp : files) {
            try {
                String read = BufferedInputFile.read(temp.getAbsolutePath(), BufferedInputFile.codeString(temp.getAbsolutePath()));
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileNAmeme),true)));
                printWriter.write(read);
                printWriter.flush();
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void getAllfiles(File dir, ArrayList<File> allfiles)
    {
        try {
            File[] files = dir.listFiles();
            if (files == null)
                return;
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isDirectory()) {
                    //递归查找
                    getAllfiles(file,allfiles);
                } else {
                    if(file.getName().contains("TABLE")) {
                        allfiles.add(file);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

