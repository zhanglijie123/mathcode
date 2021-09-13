package exerciseOne.贪心;

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
        String[] arr1 = { "A", "B", "A", "B", "C", "C", "C" ,"A" };
        printTopKAndRank(arr1, 2);
        
    }

    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.times - o2.times;
        }

    }

    public static void printTopKAndRank(String[] arr, int topK) {
        if (arr == null || arr.length == 0 || topK < 1) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            if (!map.containsKey(str)) {
                map.put(str, 0);
            }
            map.put(str, map.get(str) + 1);
        }
        topK = Math.min(arr.length, topK);
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node cur = new Node(entry.getKey(), entry.getValue());
            if (heap.size() < topK) {
                heap.add(cur);
            } else {
                if (heap.peek().times < cur.times) {
                    heap.poll();
                    heap.add(cur);
                }
            }

        }
        while (!heap.isEmpty()) {
            System.out.println(heap.poll().str);
        }
    }
}
