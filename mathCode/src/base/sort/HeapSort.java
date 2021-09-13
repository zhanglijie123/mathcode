package base.sort;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/6 0006 5:53
 * 堆排序不适用递归完成
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232};
        heapSort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static void heapSort(int[] ints) {
        if(ints ==null || ints.length<2){
            return;
        }
        //从0-n往前构造大根堆.也就是说将数组从无到有构成大根堆--构造大根堆
        for(int i=0;i<ints.length;i++){
            heapInsert(ints,i);
        }
         

       // 这个和上一步一样
       // for(int i=ints.length-1;i>=0;i--){
       //      heapFy(ints,i,ints.length-1);
       //  }
        int size = ints.length;
        //根和尾换值移除尾
        while(size>0){
            swap(ints,0,--size);
            heapFy(ints,0,size);
        }

    }

    /**
     * 将原先的大根堆的根换了之后重构大根堆--往下（基础：改变前是个大根堆，如果之前不是那么需要一一遍历构造大根堆再换根再调此方法）
     * @param ints
     * @param index
     * @param size
     */
    private static void heapFy(int[] ints, int index, int size) {
        //左孩子
        int left = 2*index+1;
        while(left<size){
            //获得孩子中最大的下标
            int largest = left+1<size && ints[left+1]>ints[left]?left+1:left;
            //和父节点作比较
            largest = ints[largest] >ints[index]?largest:index;
            if(largest==index){
                //因为根节点已经是大根堆无需往下找（前提是除了顶树外的子树之前就是根堆结构）
                break;
            }
            swap(ints,largest,index);
            index = largest;
            left = 2*index+1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 从下往上构造大根堆--如果一个大根堆某个index的值变大了，可以从该位置往上重构
     * @param ints
     * @param index 放进来的孩子下标
     */
    private static void heapInsert(int[] ints, int index) {

        //如果孩子大于根就交换--数组角标不会越界的
        while(ints[index] >ints[(index-1)/2]){
            swap(ints,index,(index-1)/2);
            index = (index-1)/2;
        }

    }
}
