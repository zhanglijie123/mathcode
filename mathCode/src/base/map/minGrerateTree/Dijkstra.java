package base.map.minGrerateTree;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }


    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
        HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
