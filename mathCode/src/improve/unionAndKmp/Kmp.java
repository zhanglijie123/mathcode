package improve.unionAndKmp;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/6 0006 16:30
 * Kmp可以用于加速完成时间复杂度到O（N）级别，但是有没有时间复杂度优化到O（LogN)级别的呢
 * next[i]表示从0-i-1的字符串str,str的前缀==后缀的最大长度.
 * 比如abbabbd的next[6]=3(abb=abb)，不能取整体abbabb=abbabb
 * 又比如aaaaak 的next[5]=4(aaaa=aaaa)
 */
public class Kmp {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {//如果str2往前推已经到head了，那么通过str2的移动是不能配出匹配的了，就让str1移动
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];//cn往前跳
            } else {
                next[i++] = 0;//说明实在没有回文字符
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }
}
