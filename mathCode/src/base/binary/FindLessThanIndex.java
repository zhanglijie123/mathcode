package base.binary;

import java.util.concurrent.TransferQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/6 0006 4:24
 * 查询局部最小的下标，有局部最小的情况返回一个下标即可
 */
public class FindLessThanIndex {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232,2};
        int[] ints2 = {212, 41, 232};
        int[] ints3 = { 232,2};
        int index  = findMinAreaIndex(ints);
        int index2  = findMinAreaIndex(ints2);
        int index3  = findMinAreaIndex(ints3);
        int index4  = findMinAreaIndex2(ints);
        int index5  = findMinAreaIndex2(ints2);
        int index6  = findMinAreaIndex2(ints3);
        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println(index5);
        System.out.println(index6);
    }

    private static int findMinAreaIndex(int[] ints) {
        if(ints ==null||ints.length==0){
            return -1;
        }
        if(ints[0]<ints[1]){
            return 0;
        }
        if(ints[ints.length-2]>ints[ints.length-1]){
            return  ints.length-1;
        }
        int l = 0;
        int r = ints.length-1;
        int mid = l+((r-l)>>1);
        while(l<r){
            if(ints[mid]>ints[mid-1]){
                r = mid-1;
                mid = l+((r-l)>>1);
            }else if(ints[mid]>ints[mid+1]){
                l = mid+1;
                mid = l+((r-l)>>1);
            }else{
                return mid;
            }
        }
        return mid;
    }
    private static int findMinAreaIndex2(int[] ints) {
        if(ints == null || ints.length==0){
            return -1;
        }
        if(ints.length == 1){
            return 0;
        }
        if(ints[0]<ints[1]){
            return 0;
        }
        if(ints[ints.length-2]>ints[ints.length-1]){
            return ints.length-1;
        }
        int l = 0;
        int r = ints.length-1;
        int mid = l+((r-l)>>1);
        while(l<r){
            if(ints[mid]>ints[mid+1]){
                l = mid;
                mid = l+((r-l)>>1);
            }else if(ints[mid]>ints[mid-1]){
                r = mid;
                mid = l+((r-l)>>1);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
