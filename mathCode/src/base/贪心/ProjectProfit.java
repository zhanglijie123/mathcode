package base.贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/24 0024 14:56
 */
public class ProjectProfit {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    /**
     *
     * @param k 选择多少个项目
     * @param W  资本
     * @param Profits  利率
     * @param Capital  本金
     * @return
     */
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }

            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
    public static int findMaximizedCapital1(int k, int W, int[] Profits, int[] Capital) {
        int size = Profits.length;
        Node[] nodes = new Node[size];
        int res = 0;
        for(int i=0;i<Profits.length;i++){
              nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> costPriority = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> profitPriority = new PriorityQueue<>(new MaxProfitComparator());
        for (Node node : nodes) {
            costPriority.add(node);
        }
        for(int i=0;i<k;i++){
            while(!costPriority.isEmpty() && costPriority.peek().c<=W){
                profitPriority.add(costPriority.poll());
            }
            if(costPriority.isEmpty()){
                return W;
            }
            //一个项目只能得到一个汇报所以不能使用while(!profitPriority.isEmpty()){  W+=profitPriority.poll().p;}
           W+=profitPriority.poll().p;
        }
        return W;
    }
}
