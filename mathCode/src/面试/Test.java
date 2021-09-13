package 面试;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/11 0011 19:34
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(sum());
    }
    public static int sum () {
        return fibo(20);
    }

    public static int fibo ( int a){
        if (a < 2) {
            return 1;
        } else {
            return fibo(a - 1) + fibo(a - 2);
        }
    }
}
