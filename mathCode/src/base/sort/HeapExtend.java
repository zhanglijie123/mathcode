package base.sort;

import java.util.PriorityQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/6 0006 13:05
 * 题目描述：
 *   堆排序扩展题目 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元 素移动的距离可以不超过k，
 *   并且k相对于数组来说比较小。请选择一个合适的 排序算法针对这个数据进行排序。
 */
public class HeapExtend {
    public static void main(String[] args) {
        int[] arr =new int[]{22,23,55,4,1};
        int k = 3;
        sortedArrDistanceLessK(arr,k);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void sortLessK(int[] arr, int k) {
        //默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        /**
         * 下面两个for保证移动不超过k位置
         */
        int i=0;
        for(;i<=Math.min(arr.length,k);i++){
            heap.add(arr[i]);
        }
        int index=0;
        for(;index<arr.length;index++,i++){
            heap.add(arr[i]);
            arr[i] = heap.poll();//此时必须拿出来否则数组元素移动距离超过k
        }
        //将堆中还有的继续拿到数组中
        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }

    }


    public static  void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {

            arr[i++] = heap.poll();
        }
    }
}
