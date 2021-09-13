package MiddleOne.classFour.Travel;

import java.util.HashMap;

import base.tree.WidthTree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 16:43
 */
public class TreeTravelWid {
        public static class Node {
            public int value;
            public Node left;
            public Node right;

            public Node(int data) {
                this.value = data;
            }
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
             Node head = new  Node(5);
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
            System.out.println("广度优先遍历");
            widthTranverse(head);
            System.out.println();
            System.out.print("最大的宽度是："+getMaxWidth(head));

    }

    private static int getMaxWidth( Node head) {
        HashMap<Node, Integer> depMap = new HashMap<>();
        Integer curDep = 0;
        Integer maxWid = 0;
        depMap.put(head,0);
        Integer curWid = 0;
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            Integer dep = depMap.get(poll);
            if(curDep.equals(dep)){
                curWid++;
            }else{
                curDep++;
                maxWid = Math.max(curWid,maxWid);
                curWid =1;

            }
            if(poll.left!=null){
                depMap.put(poll.left,dep+1);
                queue.add(poll.left);
            }
            if(poll.right!=null){
                depMap.put(poll.right,dep+1);
                queue.add(poll.right);
            }

        }
            return maxWid;
    }

    private static void widthTranverse( Node head) {
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(head);
        System.out.println("宽度遍历");
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

