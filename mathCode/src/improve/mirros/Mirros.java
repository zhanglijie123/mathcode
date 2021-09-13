package improve.mirros;

import javax.crypto.spec.PSource;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/7 0007 23:11
 */
public class Mirros {
    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 逆序打印有边界
     * @param head
     */
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    /**
     * 逆序
     * @param from
     * @return
     */
    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while(from!=null){
             next = from.right;
             from.right = pre;
             pre = from;
             from = next;
        }
        return pre;
    }

    /**
     * mirros遍历
     * @param head
     */
    public static void mirros(Node head){
        if(head==null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur!=null){
            mostRight = cur.left;//左子树
            //左子树不为空
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;//右移到左子树最右边
                }
                if(mostRight.right == null){
                    mostRight.right = cur;//让左子树最右指向当前节点
                    cur = cur.left;//遍历cur的下个左子树
                    continue;
                }else{//第二次
                    mostRight.right = null;//还原
                }

            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);

        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
    }

    /**
     * 只逆序打印有左孩子的下属右边界并且只逆序打印第二次 然后结束时反打印整个树右边界
     * @param head
     */
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        System.out.println("后续遍历：");
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }


    /**
     * mirros中序遍历是如果有左孩子的（也就是能二次访问） 打印第二次访问的，如果没有左孩子的（也就是只能访问一次的）打印第一次访问即可
     * @param head
     */
    public static void morrisIn(Node head) {
        if(head == null){
            return;
        }
        System.out.println("中序遍历：");
        Node cur = head;
        Node mostRight = null;
        while(cur!=null){
            mostRight = cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value+" ");
            cur = cur.right;
        }
        System.out.println();
    }



    /**
     * mirros先序遍历是只打印第一次访问无关有无左孩子能不能访问第二次
     * @param head
     */
    private static void morrisPre(Node head) {
        if(head ==null){
            return ;
        }
        System.out.println("先序遍历：");
        Node cur = head;
        Node mostRight = null;
        while(cur!=null){ //将整个树遍历完结束 也就是cur最终会指向null
            mostRight = cur.left;//左孩子
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;//跳到左孩子的最右节点
                }
                if(mostRight.right==null){
                    //第一次
                    System.out.print(cur.value+" ");
                    //如果最右节点为空就是第一次访问  让mostRight.right ->cur 并且让cur往左孩子再移动一次
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{

                    //如果左孩子的最右节点指向自己 那就是第二次访问了  就让mostRight.right-》null 然后让cur往右孩子移动
                    mostRight.right = null;
                }
            }else{
                //第一次
                System.out.print(cur.value+" ");
            }
            cur = cur.right;//无左孩子就移动到右孩子
        }
        System.out.println();
    }


}
