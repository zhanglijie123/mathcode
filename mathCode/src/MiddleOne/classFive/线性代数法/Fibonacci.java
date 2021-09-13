package MiddleOne.classFive.线性代数法;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 20:49
 * 斐波那契数列：
 * 1 1 2 3 5 8 13.。。。。
 * 一般方式递归完成 :至少递归遍历N遍--》O（N）
 *
 * 优化成O（LogN)
 * 斐波那契公式：F(N) = F(N-1)+F(N-2)
 * 1,1
 * 1,0
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci2(5));
    }

    /**
     * 普通解法时间复杂度O（N）
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if(n<1){
            return 0;
        }
        if(n==1|| n==2){
            return 1;
        }else{
           return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    /**
     * 整个调用时间复杂度O（logN)
     * @param n
     * @return
     */
    public static int fibonacci2(int n){
        if(n<1){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int[][] base = new int[][]{
            {1,1},
            {1,0}
        };
        int[][] res = marixPow(base,n-2);
        return res[0][0]+res[1][0];
    }

    private static int[][] marixPow(int[][] base, int n) {
        int[][] res = new int[base.length][base[0].length];
        for(int i=0;i<res.length;i++){
            res[i][i] = 1;//单位矩阵
        }
        int[][] t = base;
        for(;n!=0;n>>=1){
            if((n&1)!=0){//满足指数bit为为1情况
                res = multMaritx(res,t);
            }
            //基数矩阵在不断变化
            t = multMaritx(t,t);
        }
        return res;
    }

    /**
     * 虽然是三个for循环但是矩阵就是个2*2的大小有限。所以实际时间复杂度O(1)
     * @param t
     * @param t1
     * @return
     */
    private static int[][] multMaritx(int[][] t, int[][] t1) {
         int[][] res = new int[t.length][t1[0].length];
         for(int i=0;i<t.length;i++){
             for(int j=0;j<t1[0].length;j++){
                 for(int k=0;k<t1.length;k++){
                     res[i][j] += t[i][k]*t1[k][j];
                 }
             }
         }
         return res;
    }
}
