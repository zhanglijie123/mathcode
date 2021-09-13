package exerciseOne.贪心;

import java.util.HashMap;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 18:35
 */
public class MyHeapTopK {

    public static void main(String[] args) {
        KHeap heapNode = new  KHeap(3);
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
        public Node[] heap;
        public HashMap<String,Node>  strNodeMap;
        public HashMap<Node,Integer> indexMap;
        public int size;
        public KHeap(int K){
            heap = new Node[K];
            strNodeMap = new HashMap<>();
            indexMap = new HashMap<>();
            this.size = 0;
        }
        public void add(String str){
            Node cur = null;
            int pre = -1;
            if(!strNodeMap.containsKey(str)){
                cur = new Node(str,1);
                strNodeMap.put(str,cur);
                indexMap.put(cur,-1);
            }else{
                cur = strNodeMap.get(str);
                cur.time++;
                pre = indexMap.get(cur);
            }
            if(pre==-1){
                if(size == heap.length){
                    //满了
                    if(heap[0].time<cur.time){
                        indexMap.put(heap[0],-1);
                        heap[0] = cur;
                        indexMap.put(cur,0);
                        heapFy(heap,0,size);
                    }

                }else{
                    //灭有满
                    heap[size] = cur;
                    indexMap.put(cur,size);
                    insertFy(heap,size++);
                }
            }else{
                heapFy(heap,indexMap.get(cur),size);
            }
        }

        private void insertFy(Node[] heap, int i) {
            while(i>=0 && heap[i].time<heap[(i-1)/2].time){
                swap(heap,i,(i-1)/2);
            }
        }

        private void swap(Node[] heap, int i, int i2) {
            indexMap.put(heap[i],i2);
            indexMap.put(heap[i2],i);
            Node temp = heap[i];
            heap[i] = heap[i2];
            heap[i2] =temp;

        }

        private void heapFy(Node[] heap, int i, int size) {
            int left = 2*i+1;
            while(left<size){
                int min = (left+1)<size && heap[left+1].time<heap[left].time?left+1:left;
                min = heap[min].time<heap[i].time?min:i;
                if(i==min){
                    break;
                }
                swap(heap,min,i);
                i = min;
                left = 2*i+1;
            }
        }

        public void popK() {
            int i = 0;
            while( i<heap.length){
                System.out.println(heap[i++].val);
            }
        }
    }
    public static class Node{
        public String val;
        public int time;

        public Node(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

}
