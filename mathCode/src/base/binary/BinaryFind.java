package base.binary;

import java.util.Arrays;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/3 0003 2:49
 */
public class BinaryFind {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232,232};
        Arrays.sort(ints);
        //二分查找前提是有序
        boolean isExist = binaryFind(ints, 212);
        boolean isExist2 = binaryFind2(ints, 212);
        boolean isExist3= binaryFind3(ints, 212);
        System.out.println(isExist);
        System.out.println(isExist2);
        System.out.println(isExist3);
    }

    private static boolean binaryFind3(int[] ints, int i) {
        int l =0;
        int r = ints.length-1;
        int mid = l+((r-l)>>1);
        while(l<r){
            if(ints[mid]<i){
                l = mid;
                mid = l+((r-l)>>1);
            }else if(ints[mid]>i){
                r = mid-1;
                mid = l+((r-l)>>1);
            }else{
                return true;
            }
        }
        return false;
    }

    private static boolean binaryFind2(int[] ints, int i) {
        int l = 0;
        int r = ints.length-1;
        int mid = l+((r-l)>>1);
        while(l<r){
            if(ints[mid]>i){
                l = mid+1;
                mid = l+((r-l)>>1);
            }else if(ints[mid]<i){
                r = mid-1;
                mid = l+((r-l)>>1);
            }else{
                return true;
            }
        }
        return false;
    }

    private static boolean binaryFind(int[] ints, int i) {
       int l = 0;
       int r = ints.length-1;
       int mid = l+((r-l)>>1);
       while(l<r){
           if(ints[mid]>i){
               r = mid-1;
               mid =l+((r-l)>>1);
           }else if(ints[mid]<i){
               l = mid+1;
               mid =l+((r-l)>>1);
           }else{
               return true;
           }
       }
        return false;
    }

}
