package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/28 0028 13:44
 * 机器人达到指定位置方法数
 * 【题目】 假设有排成一行的 N 个位置，记为 1~N，N 一定大于或等于 2。开始时机器人在其中的 M 位 置上(M 一定是 1~N 中的一个)，机器人可以往左走或者往右走，如果机器人来到 1 位置，
 * 那 么下一步只能往右来到 2 位置;如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置。 规定机器人必须走 K 步，最终能来到 P 位置(P 也一定是 1~N 中的一个)的方法有多少种。
 * 给 定四个参数 N、M、K、P，返回方法数。
 * 【举例】 N=5,M=2,K=3,P=3 上面的参数代表所有位置为 1 2 3 4 5。机器人最开始在 2 位置上，
 * 必须经过 3 步，最后到 达 3 位置。走的方法只有如下 3 种: 1)从2到1，从1到2，从2到3 2)从2到3，从3到2，从2到3 3)从2到3，从3到4，从4到3 所以返回方法数 3。
 * N=3,M=1,K=3,P=3 上面的参数代表所有位置为 1 2 3。
 * 机器人最开始在 1 位置上，必须经过 3 步，最后到达 3 位置。怎么走也不可能，所以返回方法数 0。
 */
public class MachineMan {
    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 4, 4));
        System.out.println(ways2(5, 2, 4, 4));
    }



    private static int ways1(int N, int S, int K, int E) {
        if(N<1 || N<S ||S<0 || E<0 || N<E ||K<1){
            return 0;
        }
        int ways = getWays(N,S,K,E);
        return ways;
    }

    /**
     * 仅仅是尝试
     * @param n 给出的总共位置
     * @param cur 当前位置
     * @param k 还剩下的步数
     * @param e 终点位置  固定的
     * @return  方法数 条件是cur==e
     */
    private static int getWays(int n, int cur, int k, int e) {
        if(k==0){
            //如果到达位置就是满足的 return 1
           return cur==e?1:0;
        }
        //左边界
        if(cur==1){
            return  getWays(n,2,k-1,e);
        }
        //右边界
        if(cur==n){
            return getWays(n,n-1,k-1,e);
        }
        //中间位置
        return getWays(n,cur-1,k-1,e) + getWays(n,cur+1,k-1,e);
    }
    /**
     * 记忆化搜索方式--根据尝试改成动态规划
     */
    private static int ways2(int N, int S, int K, int E) {
        int[][] dp = new int[K + 1][N + 1];
        for(int i=0;i<=K;i++){
            for(int j=0;j<=N;j++){
                dp[i][j]=-1;
            }
        }
        return getWays2(N, S, K, E, dp);

    }

    private static int  getWays2(int n, int cur, int k, int e, int[][] dp) {
        //这个已经跑过了
        if(dp[k][cur] !=-1){
            return dp[k][cur];
        }
        //没路子了
        if(k==0){
            //如果到达位置就是满足的 return 1
             dp[k][cur] =cur==e?1:0;
             return dp[k][cur];
        }
        //左边界
        if(cur==1){
            dp[k][cur] = getWays2(n,2,k-1,e,dp);
            return  dp[k][cur]  ;
        }
        //右边界
       else if(cur==n){
            dp[k][cur] =getWays2(n,n-1,k-1,e,dp);
            return dp[k][cur];
        }else{
            //中间位置
            dp[k][cur] = getWays2(n,cur-1,k-1,e,dp) + getWays2(n,cur+1,k-1,e,dp);
        }

        return dp[k][cur];
    }

    /**
     * 严格表结构并且使用一行方式  压缩空间 完美之作
     * @param N
     * @param cur
     * @param K
     * @param P
     * @return
     */
    private static int ways3(int N, int cur, int K, int P) {
        int[] dp = new int[N + 1];
        dp[P] = 1;
        for(int i=1;i<=K;i++){
            int leftUp = dp[1];
            for(int j=1;j<=N;j++){
                int temp = dp[j];
                if(j==1){
                    dp[j] = dp[j+1];
                }else if(j==N){
                    System.out.println(leftUp);
                    dp[j] = leftUp;
                }else{
                    dp[j] = leftUp+dp[j+1];
                }
                leftUp = temp;
                //  left = dp[j];//如果后面赋值dp[j]可能已经被上面的if else 将dp[j]的值更改了，所以在上面先保存下
            }
        }
        return dp[cur];

    }


}
