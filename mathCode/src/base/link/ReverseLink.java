package base.link;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/6 0006 14:57
 * 反转链表
 */
public class ReverseLink {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        System.out.println("------------------单向链表开始演示---------------------");
         Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        System.out.println("单项反转");
        printLinkedList(head1);

        System.out.println("------------------双向链表开始演示---------------------");
        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;

        printDoubleLinkedList(head2);
        System.out.println("双向反转");
        printDoubleLinkedList(reverseList(head2));


    }

    /**
     * 打印双向链表
     * @param head
     */
    private static void printDoubleLinkedList(DoubleNode head) {

        if(head==null){
            return;
        }
       DoubleNode end = null;
        while(head!=null){
            System.out.println(head.value);
            end = head;
            head = head.next;
        }
        while(end!=null){
            System.out.println(end.value);
            end = end.last;
        }

    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    private static DoubleNode reverseList(DoubleNode head) {
        if(head ==null){
            return null;
        }
        DoubleNode pre = null;
        while(head!=null){
            DoubleNode next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转单项链表
     * @param head
     * @return
     */
    private static Node reverseList(Node head) {
       if(head == null){
           return null;
       }

       Node pre = null;
       Node cur = head;
       while(cur!=null){
           Node next = cur.next;
           cur.next = pre;
           pre = cur;
           cur =next;
       }
       return pre;
    }

    /**
     * 打印单项链表
     * @param head
     */
    private static void printLinkedList(Node head) {
       if(head==null){
           return;
       }
       while(head!=null){
           System.out.println(head.value);
           head = head.next;
       }
    }

}
