package base.digui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/5 0005 4:00
 *
 * 快排1和2版本都是O（n2)
 * 只有radom才达到O（nlogN).因为在中点 那么就可以使用主定理公式了
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] ints = {22,1,23,4,12,444,20,4,6,0,-1};
        quickSort(ints,0,ints.length-1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static void quickSort(int[] ints, int l, int r) {
       if(l<r) {
           swap(ints, l + (int) (Math.random() * (r - l + 1)), r);
           int[] p = partition(ints, l, r);
           quickSort(ints, l, p[0]);
           quickSort(ints, p[1] + 1, r);
       }
    }

    private static int[] partition(int[] ints, int l, int r) {
        int less = l-1;
        int more =r;
        while(l<more){
            if(ints[l]<ints[r]){
                swap(ints,++less,l++);
            }else if(ints[l]>ints[r]){
                swap(ints,--more,l);
            }else{
                l++;
            }
        }
        swap(ints,more,r);
        return new int[]{less ,more};
    }

    private static void swap(int[] ints, int j, int i) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
