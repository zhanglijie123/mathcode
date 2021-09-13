package MiddleOne.classSix;

import java.util.Map;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/29 0029 21:26
 * 去一个数组中的子数组，把子数组累加返回最大值
 * 题目如下：
 * 为了保证招聘信息的质量问题，公司为每个职位设计了打分系统，打分可以为正数，
 * 也 可以为负数，正数表示用户认可帖子质量，负数表示用户不认可帖子质量．打分的分数 根据评价用户的等级大小不定，比如可以为 -1分，10分，30分，-10分等。
 * 假设数组A 记录了一条帖子所有打分记录，
 * 现在需要找出帖子曾经得到过最高的分数是多少，用于 后续根据最高分数来确认需要对发帖用户做相应的惩罚或奖励．其中，最高分的定义为： 用户所有打分记录中，连续打分数据之和的最大值即认为是帖子曾经获得的最高分。
 * 例 如：帖子10001010近期的打 分记录为[1,1,-1,-10,11,4,-6,9,20,-10,-2],
 * 那么该条帖子曾经到达过的最高分数为 11+4+(-6)+9+20=38。请实现一段代码，输入为帖子近期的打分记录，输出为当前帖子 得到的最高分数。
 */
public class GetMaxAddingOfSubArr {
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
