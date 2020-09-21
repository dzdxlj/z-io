package zxj.fileIOStudy;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File("E:\\学习笔记及书本\\书本");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    Pattern compile = Pattern.compile(args[0]);
                    return compile.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }

    }
}
