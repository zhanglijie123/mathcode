package exerciseOne.sub;

import java.util.Arrays;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/1 0001 10:33
 * (((())这个有效的连续括号子串长度为4
 */
public class GetSubStrLenOfEffectiveKuoHao {
    public static void main(String[] args) {
        int len =  getEffectiveNumLenOfKH1("(((())");
        System.out.println(len);
    }

    private static int getEffectiveNumLenOfKH1(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] dp = new int[N];
        int pre = 0;
        for(int i=0;i<N;i++){
            if(chars[i]==')'){
                pre = i-1-dp[i-1];
                if(pre>=0 && chars[pre]=='('){
                    dp[i]=pre-1>=0?dp[i-1]+2+dp[pre-1]:dp[i-1]+2;
                }
            }
        }
        Arrays.sort(dp);
        return dp[N-1];
    }

    private static int getEffectiveNumLenOfKH(String s) {
        int N = s.length();
        int[] dp = new int[N];
        char[] chars = s.toCharArray();
        int pre = 0;
        int count =0;
        for(int i=0;i<N;i++){
            if(chars[i]==')'){
               pre = i-1-dp[i-1];
               if(pre>=0 && chars[pre]=='('){
                   dp[i] = pre-1>=0?dp[i-1]+2+dp[pre-1]:dp[i-1]+2;
               }
            }
        }
        Arrays.sort(dp);//升序
        return dp[N-1];
    }
}
