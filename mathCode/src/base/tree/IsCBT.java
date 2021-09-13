package base.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/11 0011 9:22
 * 判断是否完全二叉树
 */
public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        //  head.right.right = new Node(4); //打开这个注释就不是完去二叉树了

        boolean isCbt = isCBT(head);
        boolean isCbt2 = isCbt(head);
        System.out.println("是否完全二叉索树" + isCbt);
        System.out.println("是否完全二叉索树" + isCbt2);

    }

    /**
     * 在基于队列完成宽度遍历基础上--
     * 条件 ： 1 如果无左有右 直接return false
     * 2 如果没有孩子节点那么从此开始往下都是叶子节点，后面的如果遍历时候发现任然有孩子return false
     *
     * @param head
     * @return
     */
    private static boolean isCBT(Node head) {
        if (head == null) {
            return false;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean isLeaf = false;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if ((poll.left == null && poll.right != null) || (isLeaf && (poll.right != null || poll.left != null))) {
             return false;
            }
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }
            if(poll.left==null && poll.right==null){
                isLeaf = true;
            }
        }
        return true;
    }

    private static boolean isCbt(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeaf = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if ((poll.left == null && poll.right != null) || (isLeaf && (poll.right != null || poll.left != null))) {
                return false;
            }

            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (poll.left == null && poll.right == null) {
                isLeaf = true;
            }

        }
        return true;
    }
}
