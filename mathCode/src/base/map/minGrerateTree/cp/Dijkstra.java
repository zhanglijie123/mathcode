package base.map.minGrerateTree.cp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import base.map.base.Edge;
import base.map.base.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 21:56
 */
public class Dijkstra {
    public static void main(String[] args) {
       Node head = new Node(1);
       Node node2 = new Node(2);
       Node node3 = new Node(3);
        Edge edge = new Edge(1, head, node2);
        Edge edge1 = new Edge(2, head, node3);
        Edge edge2 = new Edge(5, node2, node3);

      head.edges.add(edge);
      head.edges.add(edge1);
      node2.edges.add(edge);
      node3.edges.add(edge1);
      node2.edges.add(edge2);
      node3.edges.add(edge2);
        HashMap<Node, Integer> nodeIntegerHashMap = dijkstra1(head);
        System.out.println(nodeIntegerHashMap.size());
        for (Integer node : nodeIntegerHashMap.values()) {
            System.out.println(node);
        }

    }
    public static HashMap<Node, Integer> dijkstra1(Node head) {
        HashMap<Node, Integer> distance = new HashMap<>();
        distance.put(head,0);
        HashSet<Node> selected = new HashSet<>();
        Node min = getMinDistanceAndUnselectedNode(distance,selected);
        while(min!=null){
            int dis = distance.get(min);
            for (Edge e : min.edges) {
                Node to = e.to;
                if(!distance.containsKey(to)){
                    distance.put(to,dis+e.weight);
                }
                distance.put(to,Math.min(distance.get(to),dis+e.weight));
            }
            selected.add(min);
            min = getMinDistanceAndUnselectedNode(distance,selected);
        }
        return distance;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distance, HashSet<Node> selected) {
        int min = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : distance.entrySet()) {
            Node key = nodeIntegerEntry.getKey();
            Integer value = nodeIntegerEntry.getValue();
            if(!selected.contains(key) && (value<min)){
                minNode = key;
                min = value;
            }
        }
        return minNode;
    }

}
