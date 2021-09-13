package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/28 0028 16:59
 *   【题目】 给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的一个货币，只能用一次因为货币只有一个，再给定一个整数 aim，代表要找的钱数，求组成 aim 的最少组成方法数
 *
 */
public class CoinWaysOnlyTry {
    public static void main(String[] args) {
      int[] arr =  new int[]{5,2,3};
      int ways = getWays(arr,5);
        System.out.println(ways);
    }

    private static int getWays(int[] arr, int aim) {
        return process(arr,aim,0,0);
    }

    private static int process(int[] arr, int aim, int index, int alreadyCoins) {
        if(index==arr.length){
            return alreadyCoins==aim?1:0;//到边界了还没违规说明可以使用此方式 return1
        }

        //返回要或者不要正在遍历的硬币，由于方法最小所以取min
        return process(arr,aim,index+1,alreadyCoins)+process(arr,aim,index+1,alreadyCoins+arr[index]) ;
    }
}
