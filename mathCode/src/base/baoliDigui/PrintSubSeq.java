package base.baoliDigui;

import java.util.ArrayList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/25 0025 22:54
 *
 */
public class PrintSubSeq {
    public static void main(String[] args) {
        String test ="bcbbca";

        printSubSeq(test);
    }


    private static void printSubSeq(String test) {
        char[] chars = test.toCharArray();

          process(chars,0,new ArrayList<Character>());
        //节约空间方式
      //  process(chars,0);//这种方式不能使用因为chars[i]=0只是让这个字符隐藏了chars的长度还是一直原来那样 当你String.valueOf({'a','b', })时候 其实他的长度不是2是3。所以比较时候"ab"==String.valueOf({'a','b', }) 将是false
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

    /**
     * 浪费空间方式
     * @param chars
     * @param i
     * @param res
     */
    private static void process(char[] chars, int i, ArrayList<Character> res){
        if(i==chars.length){
           println(String.valueOf(res));//string 问题严重可以用list代替
           return;
        }
        ArrayList<Character> you = CopyChars(res);
        you.add(chars[i]);
        process(chars,i+1,you);//这个you不干扰下面的 下面的res还是灭有add(chars[i])的
        /* ArrayList<Character> wu = CopyChars(res);
        process(chars,i+1,wu);*/

        process(chars,i+1,res);
    }

    private static void println(String str) {
        System.out.println(str.length()+str);
    }

    private static ArrayList<Character> CopyChars(ArrayList<Character> res) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character re : res) {
            result.add(re);
        }
        return result;
    }
}


