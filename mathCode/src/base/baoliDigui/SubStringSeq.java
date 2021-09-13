package base.baoliDigui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/26 0026 20:45
 * 打印子序列
 *
 *    https://leetcode-cn.com/problems/distinct-subsequences/ -- 中级班下
 *    https://leetcode-cn.com/problems/distinct-subsequences-ii/   这个不会，因为重复元素aabdes这里面aa重复会干扰。我们子序列是任意位置保留和不保留  abdes（舍弃0位置）和 abdes（舍弃1位置）重复。这个我试了set也没用 因为
 *
 *    不调整操作
 *    调整操作
 *    回正
 */
public class SubStringSeq {
    public static void main(String[] args) {
         String test =new String("aba");
         subStr(test);


    }

    private static void subStr(String test) {
        ArrayList<List<String>> res = new ArrayList<List<String>> ();
        if(test == null){
            return ;
        }

        process (test.toCharArray() ,0,new ArrayList<Character>(),res);

        for (List<String> re : res) {

            System.out.println(re);
        }

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
            //if('a'<=re && re<='z'){使用list不需要过滤
                list.add(String.valueOf(re));
          //  }
        }
        result.add(list);
    }

    private static void println(String str) {
        System.out.println(str);
    }

    private static List<Character> cp(List<Character> res) {
        System.out.println(String.valueOf(res).length()+String.valueOf(res));
        List<Character> result = new ArrayList<>();
        for (Character re : res) {//for循环过滤掉假长度 比如[a]实际有三个，表面看一个  但是通过for过滤掉
            result.add(re);
        }
        return result;
    }

    /**
     * 节约空间方式
     * @param chars
     * @param i
     */
    private static void process(char[] chars, int i) {
        if(i==chars.length){
            System.out.println(String.valueOf(chars));//string 问题严重可以用list代替
            return;
        }
        process(chars,i+1);
        char aChar = chars[i];
        chars[i] = 0;
        process(chars,i+1);
        chars[i] = aChar;

    }

}


