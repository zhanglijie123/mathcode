package base.digui;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/18 0018 14:08
 */
public class MergeSortNew {
    public static void main(String[] args) {
        //int[] ints = {22,1,23,4,12,444,20,4,6,0,-1};
      //  int[] ints = {1, 212, 41, 232, 2};
        int[] ints = {1, 212, 41, 232, 2};

        int sum = processSum(ints,0,ints.length-1);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
        System.out.println();
        System.out.println("小和"+sum);
    }

    private static int processSum(int[] ints, int l, int r) {
        if(l==r){
            return 0;
        }
        int mid = l+((r-l)>>1);
        return processSum(ints,l,mid)+
            processSum(ints,mid+1,r)+
            mergeSum(ints,l,mid,r);
    }

    private static int mergeSum(int[] ints, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int left = l;
        int right = mid+1;
        int i = 0;
        int sum = 0;
        while(left<=mid && right<=r){
            sum += ints[left]<ints[right]?(ints[left]*(r-right+1)):0;
            help[i++] = ints[left]<ints[right]?ints[left++]:ints[right++];
        }
        while(left<=mid){
            help[i++] = ints[left++];
        }
        while(right<=r){
            help[i++] = ints[right++];
        }
        for(int k = 0;k<help.length;k++){
            ints[l+k] = help[k];
        }
        return sum;
    }

    private static void process(int[] ints, int l, int r) {
        if(l==r){
            return ;
        }
        int mid = l+((r-l)>>1);
        //下面两个process就是把它细化成二叉树
        process(ints,l,mid);
        process(ints,mid+1,r);
        //merge规约合并
        mergeArr(ints,l,mid,r);
    }

    /**
     * 空间复杂度N
     * @param ints
     * @param l
     * @param mid
     * @param r
     */
    private static void mergeArr(int[] ints, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int i = 0;
        int left = l;
        int right = mid+1;
        while(left<=mid && right<=r){
            temp[i++] = ints[left]<ints[right]?ints[left++]:ints[right++];
        }
        while(left<=mid){
            temp[i++] = ints[left++];
        }
        while(right<=r){
            temp[i++] = ints[right++];
        }
        for(int j =0 ;j<temp.length;j++){
            ints[l+j] = temp[j];
        }
    }

}
