package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/30 0030 13:36
 * 给定面值货币几个 比如 10，2，4，5  aim 20
 * 从10元，2元，4元，5元种拿货币组成最终结果==aim 20元。不限制货币数量 也就是我可以重复拿同一面值货币   返回结果：尝试的方法数
 */
public class ConisRandomZhangs {
    public static void main(String[] args) {
        int[] arr = new int[]{10,2,4,5};
        int aim = 20;
        int ways = getWays(arr,0,aim);
        System.out.println(ways);
        int ways2 = getWays2(arr,0,aim);
        System.out.println(ways2);
        int ways3 = getWays3(arr,0,aim);
        System.out.println(ways3);
    }

    /**
     *
     * 动态规划--严格表结构   时间复杂度O(arr.lenght*aim^2)
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    private static int getWays2(int[] arr, int index, int aim) {
        return 0;
    }

    /**
     * 动态规划--精致版表结构--将枚举规律总结到一般规律然后  使用已经获得数据 避免重复操作 时间复杂度到基于O（arr.length*aim）*O(aim)的加速版本O（N*aim）
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    private static int getWays3(int[] arr, int index, int aim) {
        return 0;
    }

    /**
     *
     * @param arr
     * @param index
     * @param rest
     * @return
     */
    private static int


    getWays(int[] arr, int index, int rest) {
        if(index==arr.length){
            return rest==0?1:0;
        }
        int ways=0;
        for(int zhang =0;zhang*arr[index]<=rest;zhang++){
            ways+= getWays(arr,index+1,rest-arr[index]*zhang);
        }
        return ways;
    }

}
