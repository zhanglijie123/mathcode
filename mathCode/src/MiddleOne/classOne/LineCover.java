package MiddleOne.classOne;

import java.util.Map;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/3 0003 13:50
 * 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n－1]， 给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点
 */
public class LineCover {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,8,10,16};

        int L = 14;
        System.out.println(getMAXCoverPoint(arr,L));
        System.out.println(getMAXCoverPoint2(arr,L));


    }

    private static int getMAXCoverPoint2(int[] arr, int l) {
        int max = 0;
        for (int i=0;i<arr.length;i++) {
            int leftIndex = getLeftIndexNear(arr,arr[i]-l,i);
            max = Math.max(max,i-leftIndex+1);
        }
        return max;
    }

    private static int getLeftIndexNear(int[] arr, int target, int i) {
        int left = 0;
        int right = i;
        int mid = left+((right-left)>>1);
        while(left<right){
            if(arr[mid]>=target){
                right=mid;
                mid = left+((right-left)>>1);
            }else{
                left = mid+1;
                mid = left+((right-left)>>1);
            }
        }
        return mid;

    }

    /**
     * 思路：l的右端分别和arr的每个点对齐，然后查看l的左端到右端能覆盖几个点
     * 中间可以采用二分完成，即在对其右端时候计算左端的位置Lr（l的右端-l的长度）,然后根据Lr计算数组的最左位置即可
     * @param arr
     * @param l
     * @return
     * 时间复杂度是O（N）*O（logN)
     */
    private static int getMAXCoverPoint(int[] arr, int l) {
       int res =1;
       for(int i=0;i<arr.length;i++){
           int leftIndex = getNearLeftIndex(arr,i,arr[i]-l);
           res = Math.max(res,i-leftIndex+1);
       }
       return res;
    }

    /**
     * 查看arr中距离value值最近的最左的index
     * @param arr
     * @param R
     * @return
     */
    private static int getNearLeftIndex(int[] arr, int R,int value) {

        int l = 0;
        int r = R;
        int mid = l+((r-l)>>1);
        while(l<r){
            if(arr[mid]>=value){
                r = mid;
                mid = l+((r-l)>>1);
            }else{
                l = mid+1;
                mid = l+((r-l)>>1);
            }
        }
        return mid;
    }


}
