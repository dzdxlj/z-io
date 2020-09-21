package zxj.fileIOStudy;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileTreeInfo {
    public List<File> files = new ArrayList<File>();
    public List<File> dirs = new ArrayList<File>();
    public Iterator<File> iterator(){
        return files.iterator();
    }

    public void addAll(FileTreeInfo fileTreeInfo){
        files.addAll(fileTreeInfo.files);
        dirs.addAll(fileTreeInfo.dirs);
    }

    @Override
    public String toString() {
        String a = "";
        for (File file : this.files) {
            a = a + "\n" + file.getName();
        }
        for (File file : this.dirs) {
            a = a + "\n" + file.getName();
        }
        return a;
    }

    public static FileTreeInfo walk(String start,String reg){
        return recurseDirs(new File(start),reg);
    }


    public static FileTreeInfo walk(File start,String reg){
        return recurseDirs(start,reg);
    }


    public static FileTreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static FileTreeInfo recurseDirs(File startDir, String regex){
        FileTreeInfo result = new FileTreeInfo();
        for (File item : startDir.listFiles()) {
            if(item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            }else {
                if(item.getName().matches(regex)){
                    result.files.add(item);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        FileTreeInfo table = walk("C:\\Users\\zhangxiaojun\\Desktop\\20200829发布脚本", ".*");
        System.out.println(table.toString());
    }











}
