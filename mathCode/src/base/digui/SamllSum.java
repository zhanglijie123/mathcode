package base.digui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/4 0004 3:07
 *
 */

/**
 * 小和问题归并排序的延申
 */
public class SamllSum {
    public static void main(String[] args) {
      //  int[] ints = {22,1,23,4,12,444,20,4,6,0,-1};
        int[] ints = {1, 212, 41, 232, 2};
       int sum =  process(ints,0,ints.length-1);

        System.out.println("小和为"+sum);
    }

    private static int process(int[] ints, int l, int r) {
        if(l==r){
            return 0;
        }
        int mid = l+((r-l)>>1);
       return  process(ints,l,mid)+
        process(ints,mid+1,r)+
        mergeSort(ints,l,mid,r);
    }

    private static int mergeSort(int[] ints, int l, int mid, int r) {
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

}
