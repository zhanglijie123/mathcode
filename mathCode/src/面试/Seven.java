package 面试;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class Seven {
    /**
     * 两百万条的地址 使用单存的concurrentHashmap应该装的下，如果装不下可以可以start end表示分开加载和读取
     */
    ConcurrentHashMap <String, List<String>> concurrentHashMap = new ConcurrentHashMap<String, List<String>>();
    public static void main(String[] args) throws IOException {
        // 1.txt中的逗号隔开符必须是中文的 ，
        File file = new File("1.txt");
        FileInputStream input = new FileInputStream(file);
        Seven seven = new Seven();
        seven.init(file);
        String search = (String)seven.search("222.222.22.22");
        System.out.println(search);
    }
    public void init( File file) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String strLine = null;
        while((strLine=bufferedReader.readLine())!=null){
            String[] split = strLine.split("，");
            ArrayList<String> res = new ArrayList<>();
            for(int i=1;i<split.length;i++){
                 res.add(split[i]);
            }
            concurrentHashMap.put(split[0],res);
        }
    }
    public Object search(String ip){
        String res ="{";
        res += "\r\n";
        List<String> mesg = concurrentHashMap.get(ip);
        for(int i=0;i<mesg.size();i++){
            if(i==0) {

                res += "    country: " + mesg.get(i)+",";
            }else if(i==1){
                res += "\r\n";
                res += "    province: " + mesg.get(i)+",";
            }else if(i==2){
                res += "\r\n";
                res += "    city: " + mesg.get(i)+",";
            }else if(i==3){
                res += "\r\n";
                res += "    county: " + mesg.get(i) ;
            }
        }
        res += "\r\n";
        res+="}";
       return res;
    }
}
