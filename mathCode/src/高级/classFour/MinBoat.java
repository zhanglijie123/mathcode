package 高级.classFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/3 0003 20:26
 */
public class MinBoat {
    // 请保证arr有序
    public static int minBoat(int[] arr, int weight) {
        Arrays.sort(arr);
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int lessR = -1;
        if(arr[0]>weight/2){
            return arr.length;
        }
        if(arr[arr.length-1]<= weight/2){
            return (arr.length+1)/2;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= (weight / 2)) {
                lessR = i;
                break;
            }
        }
        if (lessR == -1) {
            return arr.length;
        }
        int lessIndex = lessR;
        int moreIndex = lessR + 1;
        int lessUnused = 0;
        while (lessIndex >= 0) {
            int solved = 0;
            while (moreIndex < arr.length
                && arr[lessIndex] + arr[moreIndex] <= weight) {
                moreIndex++;
                solved++;
            }
            if (solved == 0) {
                lessUnused++;
                lessIndex--;
            } else {
                lessIndex = Math.max(-1, lessIndex - solved);
            }
        }
        int lessAll = lessR + 1;
        int lessUsed = lessAll - lessUnused;
        int moreUnsolved = arr.length - lessR-1  - lessUsed;
        return lessUsed + ((lessUnused + 1) >> 1) + moreUnsolved;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 2, 4, 4, 4, 4, 5 };
        int weight = 5;
        System.out.println(minBoat(arr,weight));
        int[] arr1 = { 2,6,8,9 };
        int weight1 = 10;
        System.out.println(minBoat(arr1, weight1));
    }
}
