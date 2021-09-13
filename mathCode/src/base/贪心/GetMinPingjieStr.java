package base.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/23 0023 21:38
 * 获得字符串数组拼接最小值
 */
public class GetMinPingjieStr {

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));
        System.out.println(lowestString2(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
        System.out.println(lowestString2(strs2));
    }

    private static String lowestString2(String[] str) {
        if(str==null || str.length==0){
            return "";
        }
        Arrays.sort(str,new StringComparator());
        String res = "";
        for (String s : str) {
            res+=s;
        }
        return res;
    }

    private static String  lowestString(String[] strs) {
        if(strs== null || strs.length==0){
            return "";
        }
        Arrays.sort(strs,new StrComparator());
        String  res ="";
        for(String  str:strs){
            res+=str;
        }
        return res;
    }


    public static class StrComparator implements Comparator<String > {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }///
    }


    public static class StringComparator implements  Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
}
