package MiddleOne.classThree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/3 0003 17:37
 * 给定一个字符串类型的数组arr，求其中出现次数最多的前K个
 */
public class TopKInArr {
    public static void main(String[] args) {
        String[] arr1 = {"A", "B", "A", "B", "C", "C", "C", "A"};
        printTopKAndRank(arr1, 2);
    }

    private static void printTopKAndRank(String[] arr1, int k) {
        HashMap<String, Node> map = new HashMap<>();

        for (String s : arr1) {
            if (!map.containsKey(s)) {
                Node node = new Node(s);
                map.put(s, node);
            } else {
                Node node = map.get(s);
                node.times++;
                map.put(s, node);

            }
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(new MyComparator());
        for (Map.Entry<String, Node> stringNodeEntry : map.entrySet()) {

            Node value = stringNodeEntry.getValue();
            if (heap.size() < k) {
                heap.add(value);

            } else {
                if (heap.peek().times < value.times) {
                    heap.poll();
                    heap.add(value);

                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(heap.poll().name);
        }
    }

    public static class MyComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.times - o2.times;
        }
    }

    public static class Node {
        public String name;
        public int times;

        public Node(String name) {
            this.name = name;
            this.times = 1;
        }
    }

}
