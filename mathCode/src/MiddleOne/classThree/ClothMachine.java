package MiddleOne.classThree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/19 0019 13:54
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入: [1,0,5]
 *
 * 输出: 3
 *
 * 解释:
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClothMachine {
    public static void main(String[] args) {
        int [] arr = new int[]{1,0,5};
        int [] arr1 = new int[]{100,0,0,0};
        int less = getLessMove1(arr);
        int less1 = getLessMove1(arr1);
        System.out.println(less);
        System.out.println(less1);
    }

    private static int getLessMove1(int[] arr) {
        int has =0;
        int moves = 0;
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        int size = arr.length;
        if(sum%size!=0){
            return  -1;
        }
        int avg = sum/size;
        for(int i=0;i<arr.length;i++){
            int left = has-avg*i;
            int right = sum-has-arr[i]-(avg*(size-i-1));
            if(left<0 && right<0){
                moves = Math.max(moves, Math.abs(left)+Math.abs(right));
            }else{
                moves = Math.max(moves,Math.max(Math.abs(left),Math.abs(right)));
            }
            has+=arr[i];
        }
        return moves;
    }

    private static int getLessMove(int[] arr) {
        int size = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        if(sum%size!=0){
            return -1;
        }
        int avg = sum/size;
        int has = 0;
        int min = 0;
        for(int i=0;i<arr.length;i++){
            int L = avg*i-has;//左侧总值缺少或者多了多少
            int R = (size-i-1)*avg-(sum-has-arr[i]);//右侧总之缺少或者多了多少
            if(L>0 && R>0){
                min = Math.max(min,L+R);
            }else{
                min = Math.max(min,Math.max(Math.abs(L),Math.abs(R)));
            }
            has +=arr[i];
        }
        return  min;

    }
}
