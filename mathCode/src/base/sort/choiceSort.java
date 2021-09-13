package base.sort;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/3 0003 1:08
 * 选择排序
 */
public class choiceSort {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232,222,3,5,9};
        selectSort(ints);
        for(int i: ints){
            System.out.println(i);
        }
    }



    private static void selectSort(int[] ints) {

        for(int i=0;i<ints.length-1;i++){
            for(int j=i+1;j<ints.length;j++){
                if(ints[i]>ints[j]){
                    swap(ints,i,j);
                }
            }
        }
        /*for(int i=0;i<ints.length-1;i++){
            for(int j = i+1;j<ints.length;j++){
                if(ints[i]>ints[j]){
                    swap(ints,i,j);
                }
            }
        }*/
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

}
