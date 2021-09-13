package improve.bigData;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/27 0027 23:19
 * 通过位运算完成加减乘除
 */
public class AddSubMulDivByBit {
    /**
     * ^表示无进位相加  a&b表示该位的进位标识
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
       int sum = 0;
       while(b!=0){
           sum = a^b;
           b = (a&b)<<1;
           a =  sum;
       }
       return  sum;
    }

    /**
     * 相反数就是该数的取反+1.取反范围包含符号位  比如00000000000000000000000000001 的相反数 11111111111111111111111111 .最高位是符号位
     * @param n
     * @return
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;//无符号右移
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
       int x = isNeg(a)?negNum(a):a;
       int y = isNeg(b)?negNum(b):b;
       int res =0 ;
       for(int i=31;i>=0;i=minus(i,1)){
           if((x>>i)>=y){
               res |=(1<<i);
               x=minus(x,y<<i);
           }
       }
        return isNeg(a)^isNeg(b)?negNum(res):res;

    }



    public static void main(String[] args) {
      /*  int a = (int) (Math.random() * 100000) - 50000;
        int b = (int) (Math.random() * 100000) - 50000;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println(add(a, b));
        System.out.println(a + b);
        System.out.println("=========");
        System.out.println(minus(a, b));
        System.out.println(a - b);
        System.out.println("=========");
        System.out.println(multi(a, b));
        System.out.println(a * b);
        System.out.println("=========");
        System.out.println(divide(a, b));
        System.out.println(a / b);
        System.out.println("=========");

        a = Integer.MIN_VALUE;
        b = 32;
        System.out.println(divide(a, b));
        System.out.println(a / b);*/
        System.out.println(div(-4,-2));
        System.out.println(add(2,4));

    }

}
