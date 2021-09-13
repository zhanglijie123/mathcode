package MiddleOne.classFour;

import java.util.Arrays;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 14:01
 * 给定一个数组arr长度为N，你可以把任意长度大于0且小于N的前缀作为左部分，剩下的
 * 作为右部分。但是每种划分下都有左部分的最大值和右部分的最大值，请返回最大的
 * 左部分最大值减去右部分最大值的绝对值。
 */
public class MaxDistanceOnSpiltArr {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,1,2,5,2,4};//5
        int[] arr2 = new int[]{4,5,1,3,2};//2
        int[] arr3 = new int[]{4,2,0,3,2,5};//9
        int res1 = getMaxBySpilt(arr1);
        int res2 = getMaxBySpilt(arr2);
        int res3 = getMaxBySpilt(arr3);
        int res4 = getMaxBySpilt2(arr1);
        int res5 = getMaxBySpilt2(arr2);
        int res6= getMaxBySpilt2(arr3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
    }

    private static int getMaxBySpilt2(int[] arr2) {
        int first = arr2[0];
        int last = arr2[arr2.length-1];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr2.length;i++){
            max  = Math.max(max,arr2[i]);
        }
        return Math.max(Math.abs(max-last),Math.abs(max-first));
    }

    private static int getMaxBySpilt(int[] arr) {
        int first  = arr[0];
        int last = arr[arr.length-1];
        int leftMax = 0;
        int rightMax = 0;
        for(int i=0;i<arr.length-1;i++){
           leftMax = Math.max(leftMax,arr[i]);
        }
        for(int i=1;i<arr.length;i++){
           rightMax = Math.max(rightMax,arr[i]);
        }
        return Math.max(Math.abs(leftMax-last),Math.abs(rightMax-first));
    }
}
