package exerciseOne.stackOrQueue.travelTestMyQueueAndMyStack;

import java.util.HashMap;

import MiddleOne.classFour.Travel.MyQueue;
import MiddleOne.classFour.Travel.MyStack;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/5 0005 14:32
 *
 */
public class TreeWidTravel {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);



        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.println("宽度遍历");
        printWide(head);
        System.out.println();
        System.out.println("最大宽度");
        System.out.println(getMaxWidth(head));

    }

    private static int getMaxWidth(Node head) {
        if(head == null){
            return 0;
        }
        int max = 0;
        HashMap<Node, Integer> depMap = new HashMap<>();
        depMap.put(head,0);
        int curDep = 0;
        int wide = 0;
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
           if(curDep == depMap.get(poll)){
               wide++;
           }else{

               max = Math.max(max,wide);
               curDep++;
               wide =1;//下个时候wid必须1起步
           }
            if(poll.left!=null){
                depMap.put(poll.left,depMap.get(poll)+1);
                queue.add(poll.left);
            }
            if(poll.right!=null){
                depMap.put(poll.right,depMap.get(poll)+1);
                queue.add(poll.right);
            }
        }
        return max;
    }

    private static void printWide(Node head) {
        if(head == null){
            return;
        }
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.print(poll.value);
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }
        }

    }

}
