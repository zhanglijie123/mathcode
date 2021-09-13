package base.digui;

import java.util.Random;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/18 0018 13:38
 */
public class QuickSortNew {
    public static void main(String[] args) {
        int[] arr = {22,1,23,4,12,444,20,4,6,0,-1};
        quick(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quick(int[] arr, int l, int r) {
        if(l<r){
            swap(arr,l+(int)(Math.random()*(r-l+1)),r);
            int[] var = partition(arr,l,r);
            quick(arr,l,var[0]);
            quick(arr,var[1]+1,r);
        }

    }
//原型target是单独一个num而不是(r)ints[ints.lenth-1]，然后more边界就是ints.length而不是r(ints.length-1)
    //所以如果target变成了ints[ints.length-1],more变成ints.length-1.由于比较过程中target是不换位子的而是作为参照物比较。结束后需要swap(more,r）
    private static int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int i = l;
        int more = r;
        while(i<more){
            if(arr[i]<arr[r]){
                swap(arr,++less,i++);
            }else if(arr[i]>arr[r]){
                swap(arr,--more,i);
            }else{
                i++;
            }
        }
        swap(arr,more,r);
        return new int[]{less,more};

    }

    private  static void swap(int[] arr,int i,int i2){
        int temp = arr[i];
        arr[i] = arr[i2];
        arr[i2] = temp;
    }

}
