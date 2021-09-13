package base.sort;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/18 0018 15:31
 */
public class HeapSortNew {
    public static void main(String[] args) {
        int[] ints = {22,1,23,4,12,444,20,4,6,0,-1};
        heapSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static void heapSort(int[] ints) {
        for(int i=0;i<ints.length;i++){
            heapInsert(ints,i);//这样从0-n-1就构成的大根堆
        }
        int size = ints.length;
        while(size>0){
            swap(ints,0,--size);
            heapFy(ints,0,size);//0到size 必须是大根堆
        }
    }
    private static void heapFy(int[] ints,int index,int size){
        int left = 2*index+1;
        while(left<size){
            int maxI = (left+1)<size && ints[left+1]>ints[left]?left+1:left;
            maxI = ints[maxI]>ints[index]?maxI:index;
            if(maxI == index){
                break;
            }
            swap(ints,maxI,index);
            index = maxI;
            left = 2*index+1;
        }

    }

    /**
     * 从下往上调整
     * @param ints
     * @param index
     */
    public static void heapInsert(int[] ints,int index){
        while(index >=0 && ints[index]>ints[(index-1)/2]){
            swap(ints,index,(index-1)/2);
            index = (index-1)/2;
        }

    }
    public static void swap(int[] ints,int i,int j){
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp ;
    }

}
