package base.map.minGrerateTree.cp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

import base.map.base.Edge;
import base.map.base.GenerateGraph;
import base.map.base.Graph;
import base.map.base.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/22 0022 21:48
 */
public class Kruskal {
    public static void main(String[] args) {
        Integer[][] arrs = {{2, 1, 2}, {1, 1, 3}, {3, 1, 4}, {9, 3, 4}, {6, 4, 5}};
        Graph graph = GenerateGraph.createGraph(arrs);
        Set<Edge> edges = k(graph);
        for (Edge edge : edges) {
            System.out.println(edge.weight);
        }
    }

    private static Set<Edge> k(Graph graph) {
        if(graph == null){
            return null;
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (Node value : graph.nodes.values()) {
            nodes.add(value);
        }
        SameSet set = new SameSet(nodes);
        Set<Edge> res = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge poll = priorityQueue.poll();
            if(!set.isSameSet(poll.from,poll.to)){
                res.add(poll);
                //合并
                set.unionSet(poll.from,poll.to);
            }

        }
        return res;

    }
    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static class SameSet {
        public HashMap<Node, List<Node>> sameSet;

        public SameSet(List<Node> nodes) {
            sameSet = new HashMap<>();
            for (Node node : nodes) {
                ArrayList<Node> list = new ArrayList<>();
                list.add(node);
                sameSet.put(node, list);
            }
        }

        public boolean isSameSet(Node node1, Node node2) {
            return sameSet.get(node1) == sameSet.get(node2);
        }

        public void unionSet(Node node1, Node node2) {
            List<Node> nodes = sameSet.get(node1);
            List<Node> nodes1 = sameSet.get(node2);
            for (Node node : nodes) {
                nodes1.add(node);
                sameSet.put(node, nodes1);
            }
        }
    }

}
