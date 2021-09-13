package MiddleTwo.贪心;

import java.util.Scanner;

import sun.rmi.server.InactiveGroupException;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/30 0030 22:54
 * 给定一个无序数组arr，求出需要排序的最短子数组的长度，对子数组排序后能使得整个数组有序，即为需要排序的数组。例如：arr=[1,5,3,4,2,6,7]返回4，因为只有[5,3,4,2]需要排序。
 *
 * 输出描述:
 * 输出一个整数，代表需要排序的最短子数组的长度。
 */
public class NoEffectiveLength {
    public static void main(String[] args) {

        System.out.println(getMinLen(new int[]{1,3,3,3,9,9,5 }));
    }

    private static int getMinLen(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length-1];
        int minIndex = -1;
        for(int i = arr.length-2;i>=0;i--){
            if(arr[i]>min){
                minIndex = i;
            }else{
                min = Math.min(min,arr[i]);
            }
        }
        if(minIndex==-1){
            return 0;
        }
        int max = arr[0];
        int maxIndex = arr.length;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]<max){
               maxIndex = i;
            }else{
                max = Math.max(max,arr[i]);
            }
        }
        return maxIndex-minIndex+1;
    }
}
