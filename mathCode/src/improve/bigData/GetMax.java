package improve.bigData;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/27 0027 23:03
 * 通过位运算符号完成最大值的判断
 */
public class GetMax {
    public static void main(String[] args) {
        int a = -3;
        int b = 1;
       int max =  getMax(a,b);
        System.out.println(max);
    }

    private static int getMax(int a, int b) {
        int c = a-b;//可能溢出
        int sa  =sign(a);//整数得1 负数得0
        int sb = sign(b);
        int sc = sign(c);
        int dif = sa^sb;//a和b的符号是否不同
        int same = flip(dif);
        int returnA = dif*sa + same*sc;//返回a的条件就是 1当a,b异号时候以a为正数1为准 2当a,b同号时候以差值符号sc为准 二者取或+
        int returnB = flip(returnA);
        return a*returnA+b*returnB;
    }





    /**
     * 如果source 是正数 返回1
     * 如果source 是负数 返回0
     * @param source
     * @return
     */
    private static int sign(int source) {
        return flip((source>>31)&1);
    }

    /**
     * 讲source 反转 1 变 o  o变1
     * @param source
     * @return
     */
    private static int flip(int source) {
        return source^1;
    }
}
