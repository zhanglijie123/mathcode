package base.map.minGrerateTree;

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
 * @since 1.1.0 2021/2/20 0020 22:02
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
        Set<Edge> edges = primMST(graph);
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

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> edges = new HashSet<>();
        //多次遍历防止森林
        for(Node  node : graph.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                //解锁边
                for(Edge e: node.edges){
                    priorityQueue.add(e);
                }
                while(!priorityQueue.isEmpty()){
                    Edge poll = priorityQueue.poll();
                    Node to = poll.to;
                    if(!set.contains(to)){
                        set.add(to);
                        edges.add(poll);
                        for(Edge e : to.edges){
                            priorityQueue.add(e);
                        }
                    }
                }
            }
        }
        return edges;

    }
}

