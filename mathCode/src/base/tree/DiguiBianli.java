package base.tree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/9 0009 13:51
 * 使用递归完成二叉树的先序中序后续遍历
 * 注意：其中先序遍历指的是深度优先遍历
 */
public class DiguiBianli {
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
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        System.out.println("前序遍历");
        preOrder(head);
        System.out.println();
        System.out.println("中序遍历");
        inOrder(head);
        System.out.println();
        System.out.println("后续遍历");
        postOrder(head);
    }

    private static void postOrder(Node head) {
        if(head==null){
         return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.value);

    }

    private static void inOrder(Node head) {
        if(head==null){
            return;
        }
        inOrder(head.left);
        System.out.print(head.value);
        inOrder(head.right);
    }

    private static void preOrder(Node head) {
        if(head==null){
            return;
        }
        System.out.print(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }
}

