package base.baoliDigui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/26 0026 12:26
 * 拿扑克牌 getMax分数
 *
 * 先手   vs     后手
 *
 * https://leetcode-cn.com/problems/Up5XYM/
 */
public class GetPuke {
    public static int winGet(int[] arr){
        if(arr==null || arr.length==0){
            return 0;
        }
        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }



    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        //别人拿走f钟最好的，所以我拿最小的
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    public static void main(String[] args) {
        //101答案
        int[] arr = new int[]{1, 2, 100, 4};
        int i = winGet(arr);
        System.out.println(i);

    }
}
