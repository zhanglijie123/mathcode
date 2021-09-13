package MiddleOne.classFive.线性代数法;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/8 0008 19:06
 * 在迷迷糊糊的大草原上，小红捡到了n根木棍，第i根木棍的长度为i， 小红现在很开心。
 * 想选出其中的三根木棍组成美丽的三角形。 但是小明想捉弄小红，想去掉一些木棍，使得小红任意选三根木棍都不能组成 三角形。
 * 请问小明最少去掉多少根木棍呢？ 给定N，返回至少去掉多少根？
 * 只要保留长度组合是斐波那契数列就行。讲不是斐波那契的长度的木棍去了就可以了
 */
public class NoSanjiaoXing {
    public static int minDelete(int m) {
        if (m < 4) {
            return 0;
        }
        int k_2 = 2;
        int k_1 = 3;
        int num = 3;
        while (k_2 + k_1 <= m) {
            num++;
            k_1 += k_2;
            k_2 = k_1 - k_2;
        }
        return m - num;
    }

    public static void main(String[] args) {
        int test = 15;
        System.out.println(minDelete(test));
    }
}
