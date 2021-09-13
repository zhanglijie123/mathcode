package base.tree;

import java.util.LinkedList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/11 0011 11:44
 * 序列化和反序列化
 */
public class SeriazeAndReSerize {
    public static class Node {
        public int value;
        public   Node left;
        public  Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
         head.left.left = new Node(4);
        head.left.right = new Node(5);

        System.out.println("=================================");
        printTreePre(head);
        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order ");
        System.out.println();
        printTreePre(head);


    }







    private static Node reconByPreString(String pre){
       if(pre==null){
           return null;
       }
        String[] s = pre.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for(int i=0;i<s.length;i++){
            queue.offer(s[i]);
        }
       return  reconByPre(queue);
    }

    private static Node reconByPre(LinkedList<String> queue) {
        String poll = queue.poll();
        if( poll.equals("#")){//这个equals不能使用==
           return null;
       }
        Node head = new Node(Integer.valueOf(poll));
        head.left = reconByPre(queue);
        head.right = reconByPre(queue);
        return head;
    }


    private static String serialByPre(Node head) {
       if(head == null){
           return "#_";
       }
       String value = head.value+"_";
       value+= serialByPre(head.left);
       value+= serialByPre(head.right);
       return value;
    }

    private static void printTreePre(Node head) {
        if(head == null){
            return;
        }
        System.out.println(head.value);
        printTreePre(head.left);
        printTreePre(head.right);
    }
}
