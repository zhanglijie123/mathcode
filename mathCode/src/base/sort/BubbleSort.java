package base.sort;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/3 0003 1:26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232,222,3,5,9};
        bubbleSort(ints);

        for(int i: ints){
            System.out.println(i);
        }
    }

    private static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
         /* for(int i=0;i< arr.length;i++){
              for(int j=0;j<arr.length-1-i;j++){
                  if(arr[j]>arr[j+1]){
                      swap(arr,j,j+1);
                  }
              }
          }
*/
    }
    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    /**
     * 使用异或方式交换，0^N = N  N^N=0 满足交换和结合律
     * 切记交换的时候不要同地址交换
     * @param ints
     * @param i
     * @param j
     */
    private static void swap2(int[] ints, int i, int j) {
        ints[i] = ints[i] ^ints[j];
        ints[j] = ints[i] ^ints[j];
        ints[i] = ints[i] ^ints[j];
    }
}
