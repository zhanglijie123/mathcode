package base.baoliDigui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/25 0025 22:08
 * 汉诺塔
 *
 */
public class Haniota {

    public static void main(String[] args) {
        int n =3;
        hanio(n);

    }



    private static void hanio(int n) {
        if(n>0){
            func(n,"左","中","右");
        }
    }

    private static void func(int n, String start, String end, String other) {
        if(n==1){
            System.out.println("Move "+n+" from"+start+" to"+end);
            return;
        }else{
            func(n-1,start,other,end);
            System.out.println("Move "+n+" from"+start+" to"+end);
            func(n-1,other,end,start);
        }

    }
}
