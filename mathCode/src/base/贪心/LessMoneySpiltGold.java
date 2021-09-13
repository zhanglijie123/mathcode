package base.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/23 0023 22:15
 * 切金条花费最低的钱 -- 哈夫曼编码问题
 */
public class LessMoneySpiltGold {
    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
        System.out.println(lessMoney1(arr));
    }

    private static int lessMoney1(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new GoldComparator());
        for (int i : arr) {
            priorityQueue.add(i);
        }
        int res = 0;
        //size等于一时候这个最后的值就是上次两个值相加的结果，可以使用上次的res
        while(priorityQueue.size()>1){
            Integer cur = priorityQueue.poll()+priorityQueue.poll();
            res +=cur;
            priorityQueue.add(cur);
        }
        return res;
    }
    public static class GoldComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MiniHeapCompare());
        for(int a:arr){
            heap.add(a);
        }
        int sum = 0;
        int cur = 0;
        while (heap.size()>1){
            cur = heap.poll()+heap.poll();
            sum +=cur;
            heap.add(cur);
        }
        return sum;
    }
    public static class MiniHeapCompare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }





}
