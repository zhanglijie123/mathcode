package base.map.minGrerateTree.cp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import base.map.base.Edge;
import base.map.base.GenerateGraph;
import base.map.base.Graph;
import base.map.base.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/22 0022 22:02
 */
public class Prim {
    public static void main(String[] args) {
        Integer[][] arrs = {
            {2,1,2},
            {1,1,3},
            {3,1,4},
            {9,3,4},
            {6,4,5}
        };
        Graph graph = GenerateGraph.createGraph(arrs);
        Set<Edge> edges = p(graph);
        for (Edge edge : edges) {
            System.out.println(edge.weight);
        }
    }
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
   //这个是从点出发
    private static Set<Edge> p(Graph graph) {
        HashSet<Node> set = new HashSet<>();
        Set<Edge> res = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        for (Node value : graph.nodes.values()) {
            if(!set.contains(value)){
                set.add(value);
                //解锁
                for (Edge edge : value.edges) {
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge poll = priorityQueue.poll();
                    Node to = poll.to;
                    if(!set.contains(to)){
                        res.add(poll);
                        set.add(to);
                        for (Edge edge : to.edges) {
                            priorityQueue.add(edge);
                        }
                    }
                }
            }
        }
        return res;
    }
}
