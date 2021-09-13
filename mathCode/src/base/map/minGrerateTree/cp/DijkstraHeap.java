package base.map.minGrerateTree.cp;

import java.util.HashMap;
import java.util.HashSet;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import base.map.base.Edge;
import base.map.base.Node;
import base.sort.HeapExtend;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/22 0022 22:54
 */
public class DijkstraHeap {
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

    private static HashMap<Node, Integer> dijkstra1(Node head) {
        NodeHeap nodeHeap = new NodeHeap(15);
        nodeHeap.addOrUpdateOrIgnore(head,0);
        HashMap<Node, Integer> res = new HashMap<>();

        while(!nodeHeap.isEmpty()){
            Record pop = nodeHeap.pop();
            int dis = pop.dis;
            Node node = pop.node;
            for (Edge edge : node.edges) {
                Node to = edge.to;
                nodeHeap.addOrUpdateOrIgnore(to,dis+edge.weight);
            }
            res.put(node,dis);
        }
        return res;
    }

    public static  class NodeHeap{
        public Node[] nodes;
        public HashMap<Node,Integer> indexMap;
        public HashMap<Node,Integer> distanceMap;
        public int size;
        public NodeHeap(int cap ){
            nodes = new Node[cap];
            indexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }
        public boolean isEmpty(){
            return this.size == 0;
        }
        public boolean isInHeap(Node node){
            return isEntered(node) && (indexMap.get(node) !=-1);
        }
        public boolean isEntered(Node node){
            return indexMap.get(node) != null;
        }
        public void addOrUpdateOrIgnore(Node node,int dis){
            if(!isEntered(node)){
                //没进过堆这是第一次
                nodes[size] = node;
                indexMap.put(node,size);
                distanceMap.put(node,dis);
                heapInsert(nodes,size++);
                
            }else if(isInHeap(node)){
                //正在堆上
                distanceMap.put(node,Math.min(dis,distanceMap.get(node)));
                heapInsert(nodes,indexMap.get(node));
            }else{
                //曾经经过但是已经处理过了
                //ignore
            }
        }
        public Record pop(){
            Node node = nodes[0];
            Integer integer = distanceMap.get(node);
            Record record = new Record(node, integer);
            nodes[0] = null;
            swap(nodes,0,size-1);
            indexMap.put(node,-1);
            heapFy(nodes,0,--size);
            
            
            return record;
        }

        private void heapFy(Node[] nodes,int index, int size) {
            int left = 2*index+1;
            while(left<size){
                int minI = (left+1)<size && distanceMap.get(nodes[left+1])<distanceMap.get(nodes[left])?left+1:left;
                minI = distanceMap.get(nodes[minI])<distanceMap.get(nodes[index])?minI:index;
                if(index==minI){
                    break;
                }
                swap(nodes,minI,index);
                index = minI;
                left = 2*index+1;
            }
        }

        private void heapInsert(Node[] nodes, int index) {
            while(index>=0 && (distanceMap.get(nodes[index])<distanceMap.get(nodes[(index-1)/2]))){
                swap(nodes,index,(index-1)/2);
            }
        }

        private void swap(Node[] nodes, int index, int index2) {
            indexMap.put(nodes[index],index2);
            indexMap.put(nodes[index2],index);
            Node temp = nodes[index];
            nodes[index] = nodes[index2];
            nodes[index2] = temp;
        }

    }
    public static class Record{
        public Node node;
        public Integer dis;

        public Record(Node node, Integer dis) {
            this.node = node;
            this.dis = dis;
        }
    }
}
