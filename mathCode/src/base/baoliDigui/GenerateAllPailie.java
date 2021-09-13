package base.baoliDigui;

import java.util.ArrayList;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/26 0026 0:01
 * 产生str的所有排列
 *
 * https://leetcode-cn.com/problems/permutation-i-lcci/  不重复
 * https://leetcode-cn.com/problems/permutation-ii-lcci/  重复
 */
public class GenerateAllPailie {
    public static void main(String[] args) {
        ArrayList<String> ab = getAllPailie("aba");
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

    private static void getResultByProcess(char[] chars, int i, ArrayList<String> res) {
        if(chars.length==i){
            res.add(String.valueOf(chars));
        }
        boolean[] isVisit = new boolean[26];
        for(int j=i;j<chars.length;j++){
           int index = chars[j]-'a';
           if(!isVisit[index] ) {
               isVisit[index] = true;
                swap(chars, i, j);
                getResultByProcess(chars, i + 1, res);
                swap(chars, i, j);
          }
        }
    }


    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}







