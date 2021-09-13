package base.sort;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/3 0003 2:33
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232};
        insertSort(ints);
        for(int i: ints){
            System.out.println(i);
        }
    }

    private static void insertSort(int[] ints) {
        for(int i=0;i<ints.length;i++){
            for(int j=i ;j>=1 && ints[j]<ints[j-1];j--){
                swap(ints,j,j-1);
            }
        }
       /* for (int i=1;i<ints.length;i++)
        {
             for(int j=i;j>0 && ints[j]<ints[j-1];j--){
                 swap(ints,j,j-1);
             }

        }*/
    }

    private static void swap(int[] ints, int j, int i) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
