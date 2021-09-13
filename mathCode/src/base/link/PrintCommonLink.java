package base.link;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/6 0006 15:55
 * 打印两个有序链表共同部分 -- 注意这两链表是有序的哦
 */
public class PrintCommonLink {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
       if(head1==null || head2==null){
           return;
       }
       while(head1!=null && head2!=null){
           if(head1.value>head2.value){
               head2 = head2.next;
           }else if(head1.value<head2.value){
               head1 = head1.next;
           }else{
               System.out.print(head1.value);
               head1 = head1.next;
               head2 = head2.next;
           }
       }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(7);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        System.out.println("相同部分");
        printCommonPart(node1, node2);

    }
}
