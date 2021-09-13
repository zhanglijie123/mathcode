package base.baoliDigui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/26 0026 17:16
 */
public class NqueueShow {
    public static void main(String[] args) {
        int n =4;
        List<List<String>> num = getNum(n);
        for (List<String> strings : num) {
            System.out.println(strings);
        }

    }

    private static List<List<String>> getNum(int n) {
        ArrayList<List<String>> lists = new ArrayList<>(n);
        if(n==0){
            return null;
        }
        if(n==1){
            ArrayList<String> strs = new ArrayList<>();
            strs.add("Q");
            lists.add(strs);
            return lists;
        }
        int[] part = new int[n];

        process(n,part,0,lists);
        return lists;
    }

    /**
     *
     * @param n 一共多少行
     * @param part  行的列信息
     * @param i  正在遍历的行
     * @return
     */
    private static int process(int n, int[] part,int i,ArrayList<List<String>> lists) {
        if(i==n){
            delsRes(part,lists);
            return 1;
        }
            int res = 0;
            for(int j=0;j<n;j++){
                if(valaid(part,i,j)){
                    part[i] = j;
                    res+=process(n,part,i+1,lists);

                }
            }
         return  res;
    }

    private static void delsRes(int[] part, ArrayList<List<String>> lists) {
       String str = "";
        ArrayList<String> strings = new ArrayList<>();
        for(int i=0;i<part.length;i++){
            int index = part[i];
            for(int j=0;j<part.length;j++){
                if(j==index){
                    str+="Q";
                }else{
                    str+=".";
                }

            }

            strings.add(str);
            str="";
        }
       lists.add(strings);

    }

    private static boolean valaid(int[] part, int i, int j) {
        for(int k=0;k<i;k++){
            if((part[k]== j || (Math.abs(part[k]-j)==Math.abs(i-k)))){
                return false;
            }
        }
        return true;
    }
}
