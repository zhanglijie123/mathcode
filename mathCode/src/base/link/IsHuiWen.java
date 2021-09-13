package base.link;

import java.util.Stack;

import improve.unionAndKmp.cp.IsReloadStr;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/6 0006 16:04
 */
//head = head.next和head.next = null.前者是不会影响别的方法对这个链表的操作的，后者改变了引用链表的结构则会影响其他方法对链表的操作

/**
 * 总结位置：
 * Node n1 = head;
 * Node n2 = head;
 * while(n2.next!=null && n2.next.next !=null){
 * n1 = n1.next;
 * n2 = n2.next.next;
 * }
 * 这个代码执行完后，如果链表长度为奇数，那么n1的位置处于正中间比如  A>B>C>D>E   n1 就在C位置上
 * 如果链表长度为偶数，那么n1的位置就处于前半部分的尾节点处，  A>B>C>D  n1就在B的位置上
 * 所以用半边栈的方式用来装链表的右边部分就需要让 n1 = n1.next作为有部分的首位置
 */
public class IsHuiWen {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

    /**
     * 1首先打到中点，然后将右半部分反转。原先中点next=null,反转后的右边尾巴指向原先中点位置最后指向空
     * 2  第1步已经完成了将一条链表拆成两个链表 比如原来的 A->B->C->D   A->B->null  D->C->null
     * 3.循环比较两个链表是否相等
     * 4.还原链表
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node cur = head;
        Node nextNext = cur;
        while(nextNext.next!=null && nextNext.next.next!=null){
            cur  =cur.next;
            nextNext = nextNext.next.next;
        }
        Node rFirst = cur.next;

        Node lLast = cur;
        cur.next = null;
        //反转右侧
        Node pre = null;
        while(rFirst!=null){
            Node next = rFirst.next;
            rFirst.next = pre;
            pre = rFirst;
            rFirst = next;
        }
        //判断两边是否回文
        boolean isHW = true;
        Node lF = pre;
        Node rF = head;
        while(lF!=null && rF!=null){
            if(lF.value!=rF.value){
                isHW = false;
            }
            lF = lF.next;
            rF = rF.next;
        }
        //还原链表
        Node rPre = null;
        while(pre!=null){
            Node next = pre.next;
            pre.next = rPre;
            rPre = pre;
            pre = next;
        }

        lLast.next = rPre;
        return isHW;
    }

    /**
     * 使用半个栈完成--借助快慢指针完成到链表中点然后入栈
     * 如果借助容器那么针对容器的index标为起始为head.next(我已经悟到了，所以不用此方式，直接用head定到中点
     * 如果不用容器比如第三个方法就用head就行了
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome2(Node head) {
        if (head == null || (head !=null &&head.next == null)) {
            return true;
        }
        Node next = head;
        Node nNext = head;
        while(nNext.next!=null && nNext.next.next!=null){
            next = next.next;
            nNext = nNext.next.next;
        }
        //右半部分第一个
        Node rFirst = next.next;
        Stack<Node> stack = new Stack<>();
        while(rFirst!=null){
            stack.push(rFirst);
            rFirst = rFirst.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop().value!=head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 使用栈的方式完成回文 校验
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome1(Node head) {
       if(head == null || (head!=null && head.next == null)){
           return true;
       }
        Stack<Node> stack = new Stack<>();
       Node cur = head;
       while(cur!=null){
           stack.push(cur);
           cur = cur.next;
       }
       while(!stack.isEmpty()){
           if(head.value != stack.pop().value){
               return false;
           }
           head = head.next;
       }
       return true;
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
