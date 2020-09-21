package zxj.encoding;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AcailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
/*        for (String alias : map.keySet())
        {
            // 输出字符集的别名
            System.out.println(alias);
        }*/
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String csName = it.next();
            System.out.print(csName);
            Iterator<String> aliases = map.get(csName).aliases().iterator();
            if(aliases.hasNext()){
                System.out.print("：");
            }
            while(aliases.hasNext()){
                System.out.print(aliases.next());
                if(aliases.hasNext()){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
