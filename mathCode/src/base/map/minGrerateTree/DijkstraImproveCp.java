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
 * @since 1.1.0 2021/2/24 0024 22:05
 */
public class DijkstraImproveCp {
    //此算法是规定从某个节点出发，然后返回根据出发节点生成的最小生成树的（返回的是一个距离出发节点的距离map)
    public static Map<Node,Integer> getMinTreeByDijkstra(Node head){
        HashMap<Node, Integer> distance = new HashMap<>();
        distance.put(head,0);
        HashSet<Node> selected = new HashSet<>();
        Node minNode = getMinDistanceNode(distance, selected);
        while(minNode!=null){
            List<Edge> edges = minNode.edges;
            for (Edge edge : edges) {
                Node nextTo = edge.to;
                if(!distance.containsKey(nextTo)){
                    distance.put(nextTo,edge.weight+distance.get(minNode));
                }
                distance.put(nextTo,Math.min(distance.get(nextTo),edge.weight+distance.get(minNode)));
            }
            selected.add(minNode);
            minNode = getMinDistanceNode(distance,selected);
        }
        return distance;
    }

    private static Node getMinDistanceNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNode) {
        Node minNode = null;
        Integer minDis = Integer.MAX_VALUE;
        for (Node node : distanceMap.keySet()) {
            if((!selectedNode.contains(node)) && distanceMap.get(node)<minDis){
                minDis = distanceMap.get(node);
                minNode = node;
            }
        }
        return minNode;

    }

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
        Map<Node, Integer> nodeIntegerHashMap = getMinTreeByDijkstra(head);
        Map<Node, Integer> minTreeByHeap = getMinTreeByHeap(head, 3);
        for (Integer node : minTreeByHeap.values()) {
            System.out.println(node);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (Integer node : nodeIntegerHashMap.values()) {
            System.out.println(node);
        }
    }

    private static Map<Node, Integer> getMinTreeByHeap(Node head, int size) {
        HeapNode heapNode = new HeapNode(size);
        heapNode.addOrUpdateOrIgnore(head,0);
        HashMap<Node, Integer> res = new HashMap<>();
        while(!heapNode.isEmpty()){
            RecordNode pop = heapNode.pop();
            Integer distance = pop.distance;
            Node node = pop.node;
            for(Edge e:node.edges){
                Node to = e.to;
                heapNode.addOrUpdateOrIgnore(to, distance+e.weight);
            }
            res.put(node,distance);

        }
        return res;

    }

    public static class RecordNode{
        public Node node;
        public Integer distance;

        public RecordNode(Node node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static class HeapNode{
        public Node[] nodes ;
        public HashMap<Node,Integer> indexMap;
        public HashMap<Node,Integer> disMap;
        public int size;

        public HeapNode(  int size) {
            nodes = new Node[size];
            this.indexMap = new HashMap<>();
            this.disMap = new HashMap<>();
            this.size = 0;
        }
        public void addOrUpdateOrIgnore(Node node,Integer dis){
            if(isInheap(node)){
                disMap.put(node,Math.min(dis,disMap.get(node)));
                insertHeapFy(indexMap.get(node));
            }
            if(!isEntered(node)){
                nodes[size] = node;
                indexMap.put(node,size);
                disMap.put(node,dis);
                insertHeapFy( size++);
            }
        }
        public boolean isEntered(Node node){
            return indexMap.containsKey(node);
        }
        public boolean isInheap(Node node){
            return indexMap.containsKey(node) && indexMap.get(node)!=-1;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public void insertHeapFy(int index){
            while(disMap.get(nodes[index])>disMap.get(nodes[(index-1)/2])){
                swap(nodes,index,(index-1)/2);
                index= (index-1)/2;
            }

        }

        private void swap(Node[] nodes, int index, int index2) {
            indexMap.put(nodes[index],index2);
            indexMap.put(nodes[index2],index);
            Node temp = nodes[index];
            nodes[index] = nodes[index2];
            nodes[index2] = temp;
        }

        public RecordNode pop() {
            RecordNode recordNode = new RecordNode(nodes[0], disMap.get(nodes[0]));
            swap(nodes,0,size-1);
            indexMap.put(nodes[size-1],-1);
            disMap.remove(nodes[size-1]);
            heapFy(0,--size);
            return recordNode;
        }

        private void heapFy(int index, int size) {
            int left = index*2+1;
            while(left<size){
                int minChl = (left+1)<size && disMap.get(nodes[left+1])<disMap.get(nodes[left])?left+1:left;
                int min = disMap.get(nodes[index])<disMap.get(nodes[minChl])?index:minChl;
                if(index==min){
                    break;
                }
                swap(nodes,min,index);
                index= min;
                left=index*2+1;
            }
        }
    }

}
