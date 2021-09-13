package base.digui;

import java.util.Arrays;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/4 0004 2:07
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232, 2};
        if (ints != null || ints.length >= 2) {
            process(ints, 0, ints.length - 1);
        }

        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * T(N) = 2*t(N/2)+O(N^1)
     * 因此 a=2,b=2,d=1;
     * logba =d
     * 所以时间复杂度O(N^dlogN)=O(NlogN)
     *
     * @param ints
     */

    private static void process(int[] ints, int l, int r) {
        if(l==r){
            return;
        }
        int mid = l+((r-l)>>1);
        process(ints,l,mid);
        process(ints,mid+1,r);
        mergeSort(ints,l,mid,r);
    }

    private static void mergeSort(int[] ints, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int left = l;
        int i = 0;
        int right= mid+1;
        while(left<=mid && right<=r){
            help[i++] = ints[left]<ints[right]?ints[left++]:ints[right++];
        }
        while(left<=mid){
            help[i++] = ints[left++];
        }
        while(right<=r){
            help[i++]= ints[right++];
        }
        for(int k=0;k<help.length;k++){
            ints[l+k] = help[k];
        }
    }

}
