package improve.mirros;

import javax.swing.plaf.synth.ColorType;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/26 0026 19:37
 */
public class MirrosCp {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);

        inTravase(head);
        preTravase(head);
        posTravase(head);
    }

    /**
     * 逆序只打印有两次且位第二次的左孩子右边界 +整树逆序右边界
     * @param head
     */
    private static void posTravase(Node head) {
        if(head ==null){
            return;
        }
        System.out.println("后续遍历");//1325764
        Node cur = head;
        Node leftNode = null;
        while(cur!=null){
            leftNode = cur.left;
            if(leftNode!=null){
                while(leftNode.right!=null && leftNode.right!=cur){
                    leftNode = leftNode.right;
                }
                if(leftNode.right==null){
                    leftNode.right=cur;
                    cur = cur.left;
                    continue;
                }
                if(leftNode.right==cur){
                    leftNode.right = null;
                    reversePrintEdge(cur.left);//
                }
            }
            cur = cur.right;
        }
        reversePrintEdge(head);
    }

    private static void reversePrintEdge(Node node) {
       Node pre = reverseEdge(node);
       Node cur = pre;
       while(cur!=null){
           System.out.print(cur.value);
           cur = cur.right;
       }

        reverseEdge(pre);
    }

    private static Node reverseEdge(Node node) {
        Node pre = null;
        while(node!=null){
            Node next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static void mirros(Node head){
        if(head ==null){
            return;
        }
        Node cur = head;
        Node leftNode = null;
        while(cur!=null){
            leftNode = cur.left;
            if(leftNode!=null){
                while(leftNode.right!=null && leftNode.right!=cur){
                    leftNode = leftNode.right;
                }
                if(leftNode.right==null){
                    leftNode.right=cur;
                    cur = cur.left;
                    continue;
                }
                if(leftNode.right==cur){
                    leftNode.right = null;
                }
            }
            cur = cur.right;
        }
    }




    public static void morris(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        while(cur!=null){
            Node mostRight = cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }

    }
    public static void inTravase(Node head){
        if(head == null){
            return;
        }
        System.out.println("中序遍历");
        Node cur = head;
        while(cur!=null){
            Node mostRight = cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value);
            cur = cur.right;
        }
        System.out.println();
    }
    public static void preTravase(Node head){
        if(head == null){
            return;
        }
        System.out.println("先序遍历");
        Node cur = head;
        while(cur!=null){
            Node mostRight = cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                    System.out.print(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                System.out.print(cur.value);
            }

            cur = cur.right;
        }
        System.out.println();
    }
}
