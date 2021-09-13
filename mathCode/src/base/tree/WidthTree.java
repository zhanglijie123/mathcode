package base.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/9 0009 15:54
 * 5
 * 3       8
 * 2   4   7   10
 * 1        6   9   11
 */
public class WidthTree {
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
        System.out.println("广度优先遍历");
        widthTranverse(head);
        System.out.println();
        System.out.print("最大的宽度是：" + getMaxWidth(head));
        System.out.print("最大的宽度是：" + getMaxWid(head));

    }

    public static int getMaxWid(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        int dep = 1;
        Integer max = Integer.MIN_VALUE;
        Integer count = 0;
        map.put(head, 1);
        queue.add(head);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Integer curDep = map.get(poll);
            if (curDep == dep) {
                count++;
            } else {
                max = Math.max(max, count);
                dep++;
                count = 1;
            }
            if (poll.left != null) {
                map.put(poll.left, map.get(poll) + 1);
                queue.add(poll.left);
            }
            if (poll.right != null) {
                map.put(poll.right, map.get(poll) + 1);
                queue.add(poll.right);
            }

        }
        return max;
    }

    private static int getMaxWidth(Node head) {
        if(head==null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> depMap = new HashMap<>();
        depMap.put(head,0);
        Integer dep = 0;
        Integer width = 0;
        Integer maxWid = 0;
        queue.add(head);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            Integer curDep = depMap.get(poll);
            if(curDep.equals(dep)){
                width++;
            }else{
                maxWid = Math.max(width,maxWid);
                width=0;
                dep++;
            }
            if(poll.left!=null){
                depMap.put(poll.left,curDep+1);
                queue.add(poll.left);
            }
            if(poll.right!=null){
                depMap.put(poll.right,curDep+1);
                queue.add(poll.right);
            }
        }
        return maxWid;

    }

    /**
     * 宽度遍历，利用一个队列其他做法和非递归的深度优先遍历一直，这里是先左边后右边（队列完成） 5382471016911
     *
     * @param head
     */
    private static void widthTranverse(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.value);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

    }
}
