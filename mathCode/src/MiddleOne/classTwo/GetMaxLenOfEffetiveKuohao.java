package MiddleOne.classTwo;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/16 0016 1:23
 * (((())这个有效的连续括号子串最大长度为4
 */
public class GetMaxLenOfEffetiveKuohao {
    public static void main(String[] args) {
        int len = getEffectiveNumLenOfKH("(((())");
        System.out.println(len);
    }

    private static int getEffectiveNumLenOfKH(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    if ((pre - 1) >= 0) {
                        dp[i] = dp[i - 1] + 2 + dp[pre - 1];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
        }
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
