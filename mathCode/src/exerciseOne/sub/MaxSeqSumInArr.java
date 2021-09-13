package exerciseOne.sub;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/1 0001 14:00
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSeqSumInArr {

    public static void main(String[] args) {
        int[] arr = {1, 1, -1, -10, 11, 4, -6, 9, 20, -10, -2};
        System.out.println(maxSum(arr));
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(arr1));

        int[] arr2 = {-2, -3, -5, 0, 1, 2, -1};
        System.out.println(maxSum(arr2));

        int[] arr3 = {-2, -3, -5, -1};
        System.out.println(maxSum(arr3));
    }

    private static int maxSum(int[] arr) {
        int cur = 0;
        int max = 0;
        for (int i : arr) {
            cur += i;
            max = Math.max(cur, max);
            if (cur <= 0) {
                cur = 0;
            }
        }
        return max;
    }

    private int maxSubArray(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int i : nums) {
            cur += i;
            max = Math.max(cur, max);
            if (cur <= 0) {
                cur = 0;
            }
        }
        return max;
    }
}
