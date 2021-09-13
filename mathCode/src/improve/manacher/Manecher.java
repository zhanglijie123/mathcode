package improve.manacher;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/6 0006 20:05
 * 可以借助pArr【】数组获得具体信息
 */
public class Manecher {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            //这一步是至少不用验证
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //后面可能区域不止上面至少不用验证那么小 ，弥补
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;//如果不能括就失败呗
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;//#1#2#1这个的max值（半径）是4.那么对应max-1就是最大直接（受#影响而已）
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
