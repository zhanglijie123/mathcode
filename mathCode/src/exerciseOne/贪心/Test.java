package exerciseOne.贪心;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/7 0007 4:10
 *
 * 很久很久以前，有一位国王拥有5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人人数也不 同。
 * 例如有的金矿储量是500kg黄金，需要5个工人来挖掘；有的金矿储量是200kg黄金，需要3个工人 来挖掘…… 如果参与挖矿的工人的总数是10。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半的金矿。要 求用程序求出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 */
public class Test {

    public boolean isCf(int[] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return false;
            }else{
                set.add(arr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] golds = new int[]{500,200,100,20,300};
        int[] person = new int[]{15,3,2,3,4};
        Node[] moreGoldWays = getMoreGoldWays(golds, person, 10);
        for (Node moreGoldWay : moreGoldWays) {
            System.out.println(moreGoldWay.gold);
        }
    }

    private static Node[] getMoreGoldWays(int[] golds, int[] person,int total) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());
        for(int i=0;i<person.length;i++){
            if(person[i]<=total){
                priorityQueue.add(new Node(golds[i]));
            }
        }
        Node[] nodes = new Node[priorityQueue.size()];
        int index = 0;
        while(!priorityQueue.isEmpty()){
            nodes[index++] = priorityQueue.poll();
        }
        return nodes;
    }

    public static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.gold-o1.gold;
        }
    }
    public static class Node{
        public int gold;


        public Node(int gold) {
            this.gold = gold;
        }
    }
}
