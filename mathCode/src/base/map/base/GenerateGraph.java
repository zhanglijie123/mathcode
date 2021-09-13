package base.map.base;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 13:32
 */
public class GenerateGraph {
    /**
     *  2 1 3(权重 来 去）
     *  1---（2）-->3
     * @param matrix
     * @return
     */
    public static Graph createGraph(Integer[][] matrix) {

        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fNode = graph.nodes.get(from);
            Node tNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fNode, tNode);
            fNode.out++;
            tNode.in++;
            fNode.nexts.add(tNode);
            fNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;

    }

    public static void main(String[] args) {
        Integer[][] arrs = {
            {2,1,2},
            {1,1,3},
            {0,1,4},
            {0,3,4},
            {0,4,5}
        };
        Graph graph = createGraph(arrs);
        Graph graph2 = createGraph2(arrs);

    }

    private static Graph createGraph2(Integer[][] arrs) {
        return null;//todo
    }
}
