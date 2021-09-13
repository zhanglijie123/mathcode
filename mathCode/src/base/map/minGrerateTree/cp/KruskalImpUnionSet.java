package base.map.minGrerateTree.cp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import base.map.base.Edge;
import base.map.base.GenerateGraph;
import base.map.base.Graph;
import base.map.base.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/22 0022 22:54
 */
public class KruskalImpUnionSet {
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
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Kruskal.EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (Node value : graph.nodes.values()) {
            nodes.add(value);
        }
        UnionSet set = new UnionSet<>(nodes);
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
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> parentMap;
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionSet(List<V> eles) {
            this.elementMap = new HashMap<>();
            this.parentMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (V ele : eles) {
                Element<V> eleElement = new Element<V>(ele);
                elementMap.put(ele, eleElement);
                parentMap.put(eleElement, eleElement);
                sizeMap.put(eleElement, 1);
            }
        }

        public boolean isSameSet(V v1, V v2) {
            return getHeapEle(elementMap.get(v1)) == getHeapEle(elementMap.get(v2));
        }

        public void unionSet(V v1, V v2) {
            if (elementMap.containsKey(v1) && elementMap.containsKey(v2)) {
                Element<V> top1 = getHeapEle(elementMap.get(v1));
                Element<V> top2 = getHeapEle(elementMap.get(v2));
                if (top1 != top2) {
                    int size1 = sizeMap.get(top1);
                    int size2 = sizeMap.get(top2);
                    Element<V>  big = size1>=size2?top1:top2;
                    Element<V> small = top1==top1?top2:top1;
                    sizeMap.put(big,size1+size2);
                    parentMap.put(small,big);
                    sizeMap.remove(small);
                }
            }
        }

        private Element<V> getHeapEle(Element<V> vElement) {
            Stack<Element<V>> stack = new Stack<>();
            while (vElement != parentMap.get(vElement)) {
                stack.push(vElement);
                vElement = parentMap.get(vElement);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), vElement);//扁平化
            }
            return vElement;
        }
    }
}
