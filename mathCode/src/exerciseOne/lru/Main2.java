package exerciseOne.lru;

import java.util.HashMap;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/20 0020 20:55
 * /*
 *  问题B：需求:
 * 请设计一种key-value缓存系统:
 * - key是32位整数
 * - value是字符串
 * - 支持LRU淘汰机制，当存储容量达到上限时淘汰最近最少使用的k-v
 * - 请考虑结构紧凑，尽量节省内存
 * - 不要使用语言、库已有的机制，尽量从底层实现
 *
 */

public class Main2 {
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> last;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 双向链表
    public static class NodeDoubleLinkedList<K , V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // 如果一个新的节点加入，放到尾巴上去
        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }
            // newNode != null
            if (this.head == null) { // 双向链表中一个节点也没有
                this.head = newNode;
                this.tail = newNode;
            } else { // 双向链表中之前有节点，
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        // 潜台词 ： 双向链表上一定有这个node
        // node分离出，但是node前后环境重新连接
        // node放到尾巴上去
        public void moveNodeToTail(Node<K, V> node) {
            if (this.tail == node) {
                return;
            }
            if (this.head == node) { // 当前node是老头部
                this.head = node.next;
                this.head.last = null;
            } else { // 当前node是中间的一个节点
                node.last.next = node.next;
                node.next.last = node.last;
            }
            //放到尾巴上
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<K, V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<K, V> res = this.head;
            if (this.head == this.tail) { // 链表中只有一个节点的时候
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }

    }

    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> keyNodeMap;
        private NodeDoubleLinkedList<K, V> nodeList;
        private int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            this.keyNodeMap = new HashMap<K, Node<K, V>>();
            this.nodeList = new NodeDoubleLinkedList<K, V>();
            this.capacity = capacity;
        }

        public V get(K key) {
            if (this.keyNodeMap.containsKey(key)) {
                Node<K, V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (this.keyNodeMap.containsKey(key)) {
                Node<K, V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            } else { // 这是一个新加的记录，有可能出现替换
                Node<K, V> newNode = new Node<K, V>(key, value);
                //已经满了 再放就超标了  所以先移除再put
                if(this.keyNodeMap.size()==this.capacity){
                    this.removeMostUnusedCache();
                }
                this.keyNodeMap.put(key, newNode);
                this.nodeList.addNode(newNode);

            }
        }

        private void removeMostUnusedCache() {
            //移除并返回移除的节点 便于更新keyNodeMap1
            Node<K, V> removeNode = this.nodeList.removeHead();
            this.keyNodeMap.remove(removeNode.key);
        }
    }

    public static void main(String[] args) {
        MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));
    }

}
