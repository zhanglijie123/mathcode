package improve.manacher.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/24 0024 0:08
 * 求最大回文子串
 * abc1234321aba
 * 结果：  1234321
 */
public class MaxHWSub {
    public static void main(String[] args) {
        System.out.println(getSubStr("cbbd"));

    }
    public static String getSubStr(String s){

        char[] str = transDelStr(s);

        int[] pArr = new int[str.length];
        int max = getMaxRByManacher(str,pArr);
        System.out.println(max);
        int index= -1;
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<pArr.length;i++) {
            if(max == pArr[i]){
                index = i;
                break;
            }

        }
        for(int i=0;i<str.length;i++){
            buffer.append(str[i]);
        }

        String res =  buffer.toString().substring(index-max+1,index+max);
        buffer = new StringBuffer();
        String[] split = res.split("#");
        for (String s1 : split) {
            buffer.append(s1);
        }

      return buffer.toString() ;
    }

    private static int getMaxRByManacher(char[] str, int[] pArr) {
        int max = Integer.MIN_VALUE;
        int R = -1;
        int C = -1;
        for(int i=0;i<str.length;i++){
            pArr[i] = R>i?Math.min(R-i,pArr[2*C-i]):1;
            while((pArr[i]+i)<str.length && (i-pArr[i])>=0){
                if(str[(pArr[i]+i)] == str[(i-pArr[i])]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            max = Math.max(max,pArr[i]);
            if(pArr[i]+i>R){
                C = i;
                R = pArr[i]+i;
            }
        }
        return max ;
    }

    private static char[] transDelStr(String s) {
        int N = s.length();
        char[] res = new char[2 * N + 1];
        char[] chars = s.toCharArray();
        int index = 0;
        for(int i=0;i<res.length;i++){
            res[i] = (i&1)==0?'#':chars[index++];
        }
        return res;
    }

}
