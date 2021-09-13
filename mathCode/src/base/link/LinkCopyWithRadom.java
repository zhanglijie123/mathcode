package base.link;

import java.util.HashMap;

import MiddleOne.classFive.线性代数法.CowHowMany;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/9 0009 11:25
 * 拷贝一个随意指向的链表包含random节点
 */
public class LinkCopyWithRadom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 随机链表的打印
     *
     * @param head
     */
    public static void printRandLinkedList(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        //先打印next不要管radon
        System.out.println("normal节点:");
        while (cur != null) {
            System.out.print(cur.value);
            cur = cur.next;
        }
        System.out.println();
        System.out.println("randon节点");
        cur = head;
        while (cur != null) {
            System.out.print(cur.rand == null ? "-" : cur.rand.value);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4
        System.out.println("原先的--------------------");
        printRandLinkedList(head);
        System.out.println("copyMethod:-------------------");
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        System.out.println("hash--------------------");
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        System.out.println("=========================");

    }

    /**
     * 使用hash表的方式
     *
     * @param head
     * @return
     */
    private static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.value);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 在原先的node后面复制一份node,然后串起来。一一遍历照着做
     *
     * @param head
     * @return 1.连next-copyNode
     * 2.连radon-copyNode。将复制链表的randon串起来
     * 3.spilt拆分node/copyNode--结果就将复制链表next也串起来了
     */
    private static Node copyListWithRand1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
       //拷贝一份后追加
        while(cur!=null){
            Node next = cur.next;
            Node cp = new Node(cur.value);
            cur.next = cp;
            cp.next = next;
            cur = next;
        }

        //关联拷贝的random
        Node cpHead = head.next;
        cur = head;
        while(cur!=null){
            Node next = cur.next.next;
            cur.next.rand = cur.rand==null?null:cur.rand.next;
            cur = next;
        }



        //split
        cur = head;
         Node cHead = null;
        while(cur!=null){
           cHead = cur.next;
           Node node = cHead==null?null: cHead.next;
           cur.next = node;
           if(cHead!=null) {
               cHead.next = node == null ? null : node.next;
           }
            cur = node;
        }
        return cpHead;
    }

}
