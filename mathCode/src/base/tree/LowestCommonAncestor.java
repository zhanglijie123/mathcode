package base.tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/11 0011 10:46
 * 求树的最低公共祖先
 */
public class LowestCommonAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 5
     * 3        8
     * 2    4
     * 1
     * 案例 2和1的最低公共祖先是3
     *
     * @param args
     */
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.right.left = new Node(1);

        Node lowestCommonAncestor = getLca1(head, head.left.left, head.left.right.left);
        System.out.println("采用集合方式完成,公共祖先节点值为：");
        System.out.println(lowestCommonAncestor.value);

        System.out.println("采用非集合方式完成,公共祖先节点值为");
        Node lcaNode = getLowestCommonAncerstor(head, head.left.left, head.left.right.left);
        System.out.println(lcaNode.value);

    }

    /**
     * 采用非集合方式找到两个节点的公共最低祖先节点
     *
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    private static Node getLowestCommonAncerstor(Node head, Node o1, Node o2) {
       if(head ==null || head==o1 ||head==o2){
           return head;
       }
        Node left = getLowestCommonAncerstor(head.left, o1, o2);
        Node right = getLowestCommonAncerstor(head.right, o1, o2);
        if(left!=null && right!=null){
            return head;
        }
        return left !=null?left:right;

    }

    /**
     * 采用集合的方式完成找到两个节点的最低公共祖先节点
     *
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    private static Node getLca(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }
        //建立子父亲关系
        HashMap<Node, Node> parent = new HashMap<>();
        parent.put(head, head);//头的父亲还是头
        process(parent, head);
        HashSet<Node> set = new HashSet<>();
        //完成o1往上的链路
        while (parent.get(o1) != o1) {
            set.add(parent.get(o1));
            o1 = parent.get(o1);
        }
        //讲头也放入进去到链路中
        set.add(head);
        while (parent.get(o2) != o2) {
            if (set.contains(o2)) {
                return o2;
            }
            o2 = parent.get(o2);
        }
        return null;
    }

    private static Node getLca1(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> parentMap = new HashMap<>();

        parentMap.put(head, head);//头结点的父节点是自己
        process1(parentMap, head);
        HashSet<Node> set = new HashSet<>();
        set.add(head);
        while(parentMap.get(o1)!=o1){
            set.add(o1);
            o1 = parentMap.get(o1);
        }
        while(parentMap.get(o2)!=o2){
            if(set.contains(o2)){
                return o2;
            }
            o2 = parentMap.get(o2);
        }
        return null;

    }

    private static void process1(HashMap<Node, Node> parentMap, Node head) {
        if (head == null) {
            return;
        }
        parentMap.put(head.left, head);
        parentMap.put(head.right, head);
        process(parentMap, head.left);
        process(parentMap, head.right);
    }

    private static void process(HashMap<Node, Node> map, Node head) {
        if (head == null) {
            return;
        }
        map.put(head.left, head);
        map.put(head.right, head);
        //向下递归
        process(map, head.left);
        process(map, head.right);

    }
}
