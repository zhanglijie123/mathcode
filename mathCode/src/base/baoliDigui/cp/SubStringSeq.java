package base.baoliDigui.cp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/26 0026 20:45
 * 打印子序列
 *
 *    https://leetcode-cn.com/problems/distinct-subsequences/ -- 中级班下  这个还是
 *    https://leetcode-cn.com/problems/distinct-subsequences-ii/   这个不会，因为重复元素aabdes这里面aa重复会干扰。我们子序列是任意位置保留和不保留  abdes（舍弃0位置）和 abdes（舍弃1位置）重复。这个我试了set也没用 因为
 *
 *    不调整操作
 *    调整操作
 *    回正
 */
public class SubStringSeq {
    public static void main(String[] args) {

         String test = "babgbag";
         String test1 = "bag";
        int i = subStr(test, test1);
        System.out.println(i);

    }
    public static int numDistinct(String s, String t) {
         return subStr(s,t);
    }
    private static int subStr(String test,String target) {
        ArrayList<List<String>> res = new ArrayList<List<String>> ();
        if(test == null){
            return 0;
        }

        process (test.toCharArray() ,0,new ArrayList<Character>(),res);

        int count  = 0;
        for (List<String> re : res) {
            StringBuffer buffer = new StringBuffer();

            for (String s : re) {

                buffer.append(s);
            }
          String temp = buffer.toString();
            System.out.println(temp);
            if(temp.equals(target)){
                System.out.println(temp+">"+target);
                count++;
            }
        }
        return count;

    }

    private static void process(char[] toCharArray, int i, List<Character> res, List<List<String>> result) {
        if(i==toCharArray.length){
            delR(result,res);
            return;
        }
        process(toCharArray,i+1,res,result);
        List<Character> you = cp(res);

        Character temp = toCharArray[i];
        res.add(temp);
        process(toCharArray,i+1,res,result);
        res.remove(temp);


    }

    private static void delR(List<List<String>> result, List<Character> res) {
        ArrayList<String> list = new ArrayList<>();
        for (Character re : res) {
                list.add(String.valueOf(re));
        }
        result.add(list);
    }


    private static List<Character> cp(List<Character> res) {
        List<Character> result = new ArrayList<>();
        for (Character re : res) {
            result.add(re);
        }
        return result;
    }


}


