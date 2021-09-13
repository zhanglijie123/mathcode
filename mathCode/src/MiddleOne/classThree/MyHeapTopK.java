package MiddleOne.classThree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 18:35
 */
public class MyHeapTopK {

    public static void main(String[] args) {
        KHeap heapNode = new KHeap(3);
        heapNode.add("A");
        heapNode.add("A");
        heapNode.add("A");
        heapNode.add("B");
        heapNode.add("B");
        heapNode.add("C");
        heapNode.add("C");
        heapNode.add("C");
        heapNode.add("D");
        heapNode.add("E");
        heapNode.add("E");
        heapNode.add("E");
        heapNode.add("E");
        heapNode.add("E");
        heapNode.add("F");
        heapNode.add("F");
        heapNode.add("F");
        heapNode.popK();

    }
    public static class KHeap{
        public int size;
        public Node[] heap;
        public Map<String,Node> eleMap;
        public Map<Node,Integer> indexMap;

        public KHeap(int size) {
            this.size = 0;
            heap = new Node[size];
            eleMap = new HashMap<>();
            indexMap = new HashMap<>();
        }

        public void add(String a) {
            Node cur = null;
            int pre = -1;
            if(!eleMap.containsKey(a)){
                cur = new Node(a);
                eleMap.put(a,cur);
                indexMap.put(cur,-1);
                pre = -1;
            }else{
                cur = eleMap.get(a);
                cur.time++;
                pre = indexMap.get(cur);
                eleMap.put(a,cur);
            }
            if(pre==-1){
                if(size==heap.length){
                    //满了
                    if(cur.time>heap[0].time){
                        Node old = heap[0];
                        indexMap.put(old,-1);
                        heap[0] = cur;
                        indexMap.put(cur,0);
                        heapFy(heap,0,size);
                    }

                }else{
                    //没满
                    heap[size ] = cur;
                    indexMap.put(cur,size );
                    heapInsert(heap,size++);

                }
            }else{
                heapFy(heap,0,size);
            }
        }

        private void heapFy(Node[] heap, int i, int size) {
            int left = 2*i+1;
            while(left<size){
                int min = (left+1<size )&& heap[left].time>heap[left+1].time?left+1:left ;
                min = heap[min].time<heap[i].time?min:i;
                if(min==i){
                    break;
                }
                swap(heap,i,min);
                i = min;
                left = 2*i+1;
            }
        }

        private void heapInsert(Node[] heap, int i) {
            while(i>=0 && heap[i].time<heap[(i-1)/2].time){
                swap(heap,i,(i-1)/2);
                i = (i-1)/2;
            }
        }

        private void swap(Node[] heap, int i, int i1) {
            Node temp = heap[i];
            indexMap.put(heap[i],i1);
            indexMap.put(heap[i1],i);
            heap[i] = heap[i1];
            heap[i1] = temp;
        }

        public void popK() {
            for (Node node : heap) {
                System.out.println(node.name);
            }
        }
    }
    public static class Node{
        public String name;
        public int time;

        public Node(String name) {
            this.name = name;
            time = 1;
        }
    }


}
