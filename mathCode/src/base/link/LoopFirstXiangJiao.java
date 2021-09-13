package base.link;

import java.util.HashMap;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/24 0024 13:23
 * 返回两个链表相交的第一个node，
 * 这两个链表可能是有环的。
 * 分解：
 *    1.判断一个链表是否有环，如果有则返回入环的那个节点。  可以借助hashSet或者快慢指针完成
 *    2.基于1.如果相交一般是两种情况，1两个链表都没环   2两个链表都有环
 *
 *         1.两个链表都没环，那么先求出两个链表的末尾节点end1 end2.如果相交end1一定等于end2.然后计算他们长度差值。让长的先走差值，然后两个一起走，相同时候就是first相交node
 *         2.如果两链表有环，那么就三情况1.第一种就是两个有环的不相交，第二种情况就是公用一个环相交在环之外，第三情况就是相交环上
 */
public class LoopFirstXiangJiao {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
     if(head==null || head.next==null || head.next.next==null){
         return null;//三个节点之内不可能有环
     }
     Node slow = head.next;
     Node fast = head.next.next;
     while(slow!=fast){
         if(fast.next==null || fast.next.next==null){
             return null;//base case
         }
         fast = fast.next.next;
         slow = slow.next;
     }
     fast = head;
     while(fast!=slow){
         fast = fast.next;
         slow = slow.next;
     }
     return fast;
    }

    public static Node getLoopNode1(Node head){
        HashMap<Node,Node> map = new HashMap();
        while(head!=null){
            if(map.containsKey(head)){
                return map.get(head);
            }
            map.put(head,head);
            head = head.next;
        }
        return null;
    }

    public static Node noLoop(Node head1, Node head2) {
      if(head1 == null || head2 ==null){
          return null;
      }
      int n = 0;
      Node cur1 = head1;
      Node cur2 = head2;
      while(cur1.next!=null){
          n++;
          cur1 = cur1.next;
      }
      while(cur2.next!=null){
          n--;
          cur2 = cur2.next;
      }
      if(cur1!=cur2){
          return null;
      }
      cur1 = n>0?head1:head2;
      cur2 = cur1 == head1?head2:head1;
      n = Math.abs(n);
      while(n!=0){
          n--;
          cur1 = cur1.next;
      }
      while(cur1!=cur2){
          cur1 = cur1.next;
          cur2 = cur2.next;
      }
      return cur1;

    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
       if(head1==null ||head2 == null){
           return null;
       }
       if(loop1 == loop2){
           Node cur1 = head1;
           Node cur2 = head2;
           int n=0;
           while(cur1.next!=loop1){
               n++;
               cur1 = cur1.next;
           }
           while(cur2.next!=loop2){
               n--;
               cur2 = cur2.next;
           }
           cur1 = n>0?head1:head2;
           cur2 = cur1==head1?head2:head1;
           n = Math.abs(n);
           while(n!=0){
               n--;
               cur1 = cur1.next;
           }
           while(cur1!=cur2){
               cur1 = cur1.next;
               cur2 = cur2.next;
           }
           return cur1;
       }else{
         Node  cur  = loop1.next;
         while(cur!=loop1){
             if(cur==loop2){
                 return loop1;//todo
             }
             cur = cur.next;
         }
          return null;
       }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
