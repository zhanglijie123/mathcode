package MiddleOne.classFive.线性代数法;

import javax.sound.midi.Soundbank;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/2 0002 11:04
 * 爬楼梯问题
 *https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClibStairs {

    public static void main(String[] args) {
        for(int i=1;i<9;i++){
            System.out.println(i+">>>"+climbStairs(i));
        }
    }
    public int climbStairs2(int n) {
        if(n==1 || n==2){
            //一级台阶和二级台阶的爬法
            return  n;
        }
        int f1 =1;
        int f2 = 2;
        int f3 = 3;
        //从第三级开始
        for(int i=3;i<=n;i++){
            f3= f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return  f3;
    }



    /**
     * 整个调用时间复杂度O（logN)
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 3;
        }
        int[][] base = new int[][]{
            {1,1},
            {1,0}
        };
        int[][] res = marixPow(base,n-2);
        return 2*res[0][0]+res[1][0];
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
