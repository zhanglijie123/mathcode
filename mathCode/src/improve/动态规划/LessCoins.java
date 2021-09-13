package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/28 0028 17:00
 * 【题目】 给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值 的货币只用一张，再给定一个整数 aim，代表要找的钱数，求组成 aim 的最少货币数。
 *  这个货币只能拿一次
 */
public class LessCoins {
    public static void main(String[] args) {
        int[] arr =  new int[]{5,2,3};
        System.out.println(getMinCoins(arr,10));
        System.out.println(getMinCoins2(arr,10));
        System.out.println(getMinCoins3(arr,10));
    }

    /**
     * 表格
     * @param arr
     * @param target
     * @return
     */
    private static int getMinCoins3(int[] arr, int target) {
        return getLess(arr,0,target);
    }

    private static int getLess(int[] arr, int i, int target) {
        int N = arr.length;
        int[][] dp = new int[N+1][target+1];
        //先填充已经确定的 比如dp[*][0] = 0. dp[arr.lenth-1]
        for(int row=0;row<=N;row++){

            dp[row][0] = 0;
        }
        for(int col=1;col<=target;col++){
            dp[arr.length][col] = -1;
        }
        for(int r = arr.length-1;r>=0;r--){
            for(int c=1;c<=target;c++){
                int wu = dp[r+1][c];
                int yao = -1;
                if(c-arr[r]>=0){
                    yao = dp[r+1][c-arr[r]];
                }

                if(wu==-1 && yao==-1){
                    dp[r][c] =  -1;
                }else {
                    if(yao==-1){
                        dp[r][c] = wu;
                    }else if(yao!=-1) {
                        dp[r][c] =  1+yao;
                    }else{
                        dp[r][c] =  Math.min(yao+1,wu);
                    }
                }


            }
        }



        return dp[i][target];//0,10
    }

    /**
     * 记忆树
     * @param arr
     * @param aim
     * @return
     */
    private static int getMinCoins2(int[] arr, int aim) {
        if(arr==null || arr.length==0 ){
            return -1;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<aim+1;j++){
                dp[i][j] =-2;
            }
        }
        return processDp(arr,0,aim,dp);
    }
    private static int processDp(int[] arr, int i, int rest,int[][]dp) {
        if(rest<0){
            dp[i][rest] =  -1;
            return dp[i][rest];
        }
        if(dp[i][rest] !=-2){
            return dp[i][rest];
        }
        if(rest==0){
            dp[i][rest] =  0;
            return dp[i][rest];
        }
        if(i==arr.length){
            dp[i][rest] = -1;
            return dp[i][rest];
        }
        int p1 = process(arr,i+1,rest);
        int p2 = process(arr,i+1,rest-arr[i]);
        if(p1==-1 && p2==-1){
            dp[i][rest] =  -1;
            return dp[i][rest];
        }else {
            if (p1 == -1) {
                dp[i][rest] =  1 + p2;
                return dp[i][rest];
            }
            if (p2 == -1) {
                dp[i][rest] =  p1;
                return dp[i][rest];
            }
            dp[i][rest] =  Math.min(p1, p2+1);
        }
        return  dp[i][rest];
    }

    /**
     * 递归尝试
     * @param arr
     * @param aim
     * @return
     */
    private static int getMinCoins(int[] arr, int aim) {
          if(arr==null || arr.length==0 ){
              return -1;
          }
          return process(arr,0,aim);
    }

    private static int process(int[] arr, int i, int rest) {
        if(rest<0){
            return -1;
        }
        if(rest==0){
            return 0;
        }
        if(i==arr.length){
            return -1;
        }
        int p1 = process(arr,i+1,rest);
        int p2 = process(arr,i+1,rest-arr[i]);
        if(p1==-1 && p2==-1){
            return -1;
        }else {
            if (p1 == -1) {
                return 1 + p2;
            }
            if (p2 == -1) {
                return p1;
            }
            return Math.min(p1, p2+1);
        }
    }
}
