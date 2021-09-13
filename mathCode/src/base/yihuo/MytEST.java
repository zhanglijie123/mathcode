package base.yihuo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/19 0019 12:30
 */
public class MytEST {
    public static void main(String[] args) throws Exception {
        File file = new File("F:\\mathCode\\src\\base\\yihuo\\ss\\1.txt");
        File file2 = new File("F:\\mathCode\\src\\base\\yihuo\\ss\\2.txt");
        FileReader fileInputStream = new FileReader(file);
        FileWriter fileOutputStream = new FileWriter(file2);
        char[] bytes = new char[8];
         int len =0;
        while(  (len =fileInputStream.read(bytes)) !=-1){


            java.lang.String s = new java.lang.String(bytes,0,len);
            fileOutputStream.write(bytes,0,len);
            fileOutputStream.flush();
            System.out.println(s);
        }

    }
}
