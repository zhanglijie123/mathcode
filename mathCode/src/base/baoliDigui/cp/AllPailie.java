package base.baoliDigui.cp;

import java.util.ArrayList;

import sun.plugin2.message.GetAppletMessage;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/29 0029 20:54
 */
public class AllPailie {


    public static void main(String[] args) {

        ArrayList<String>  ab= getAllPailie("12345");

        for (String s : ab) {
            System.out.println(s);
        }

    }

    private static ArrayList<String> getAllPailie(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str==null ||str.length()==0){
            return res;
        }
        char[] chars = str.toCharArray();
        getResultByProcess(chars,0,res);
        return res;
    }
   static int state  = 0;
    private static void getResultByProcess(char[] chars,int i,ArrayList<String> res){
        if(chars.length==i){
            res.add(String.valueOf(chars));
        }
        state++;
        //过滤掉之前使用过的 防止123 和123重复打印
        boolean[] isVisit = new boolean[26];
        for(int j=i;j<chars.length;j++){
            int index = chars[j]-'0';
            if(!isVisit[index]){
                isVisit[index] = true;
                swap(chars,i,j);
                getResultByProcess(chars,i+1,res);
                swap(chars,i,j);
            }
        }

    }



    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
