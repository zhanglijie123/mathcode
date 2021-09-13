package base.map.minGrerateTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import base.map.base.GenerateGraph;
import base.map.base.Node;
import base.map.base.Edge;
import base.map.base.Graph;
import base.yihuo.MytEST;
import javafx.scene.input.GestureEvent;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 17:36
 * K算法：指的是按边的权重以小到大顺序搭建最小生成树，边的要或者舍根据并查集完成。此案例并查集简单实现后面课程会优化到 O（1）级别
 */
public class Kruskal {
    public static void main(String[] args) {
        Integer[][] arrs = {
            {2,1,2},
            {1,1,3},
            {3,1,4},
            {9,3,4},
            {6,4,5}
        };
        Graph graph = GenerateGraph.createGraph(arrs);
        Set<Edge> edges = kruskalMST(graph);
        for (Edge edge : edges) {
            System.out.println(edge.weight);
        }
    }

    public static  class EdgeComparator implements  Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    public static Set<Edge> kruskalMST(Graph graph) {
        //比较容器
        ArrayList<Node> nodes = new ArrayList<>();
        for(Node next:graph.nodes.values()){
            nodes.add(next);
        }
        MySets mySets = new MySets(nodes);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Edge> res = new HashSet<>();
        for(Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        while(!priorityQueue.isEmpty()){
            Edge poll = priorityQueue.poll();
            if(!mySets.isSameSet(poll.from,poll.to)){
               res.add(poll);
               mySets.union(poll.from,poll.to);
            }
        }
        return res;
    }

    public static class MySets{
       public Map<Node,List<Node>> map = new HashMap<>();
       //每个初始化都单独k-node v-arr
       public MySets(List<Node> nodes){
           for(Node node:nodes){
               ArrayList<Node> arr = new ArrayList<>();
               arr.add(node);
               map.put(node,arr);
           }
       }
       //查看即将连接起来的node会不会形成个环
       public boolean isSameSet(Node from,Node to){
           return  map.get(from) == map.get(to);
       }
       //如果连接的两个node不会产生环就链接起来然后合并到同一个集合中
       public void union(Node from,Node to){
           List<Node> fromList = map.get(from);
           List<Node> toList = map.get(to);
           for (Node node : toList) {
               fromList.add(node);
               map.put(node,fromList);
           }
       }
    }

}
