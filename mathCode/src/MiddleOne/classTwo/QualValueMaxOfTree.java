package MiddleOne.classTwo;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/16 0016 15:32
 *
 * 二叉树每个结点都有一个int型权值，给定一棵二叉树，要求计算出从根结点到 叶结点的所有路径中，权值和最大的值为多少。
 * 这里的权值指的是节点值
 */
public class QualValueMaxOfTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value ) {
            this.value = value;
        }
    }

   public static Integer MAX = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node head = new Node(4);
        head.right = new Node(2);
        head.right.right = new Node(1);

        head.left = new Node(5);
        //非套路方式
        int max = getMaxQ2(head,0);
        System.out.println(max);
    }

    private static int getMaxQ2(Node head, int i) {
        if(head  ==null && head ==null){
            MAX = Math.max(i,MAX);
         //   return 0;
        }
        if(head!=null) {
            getMaxQ2(head.left, i + head.value);
        }
        if(head!=null) {
            getMaxQ2(head.right, i + head.value);
        }
        return MAX;
    }

    private static int getMaxQ(Node head,int has) {
        if(head.right==null && head.left==null){
             MAX = Math.max(has,MAX);
        }
        if(head.left!=null){
            getMaxQ(head.left,has+head.left.value);
        }
        if(head.right!=null){
            getMaxQ(head.right,has+head.right.value);
        }
        return MAX;

    }
}
