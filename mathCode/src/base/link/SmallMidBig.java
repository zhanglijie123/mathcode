package base.link;

import javax.lang.model.element.VariableElement;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/9 0009 7:03
 * 给定一个链表比如 4->3->7->21->1将他按照taoget进行左边小于target 右边大于target 中间等于target
 * 比如target 为7   结果1->4—>3->7->21
 */
public class SmallMidBig {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next.next= new Node(0);
        System.out.println("——————————————————————————调整前————————————————————————————————————");
        printLinkedList(head1);
        head1 = listPartition2(head1, 5);
        //head1 = someVar2(head1, 5);
        System.out.println("——————————————————————————调整后————————————————————————————————————");
        printLinkedList(head1);

    }

    private static Node someVar2(Node head, int target) {
        Node smallH = null;
        Node smallT = null;
        Node equalH = null;
        Node equalT = null;
        Node bigH = null;
        Node bigT = null;
        while(head!=null){
            Node next = head.next;
            head.next = null;
            if(head.value<target){
                if(smallH == null){
                    smallH = head;
                    smallT = head;
                }else{
                    smallT.next = head;
                    smallT = head;
                }
            }else if(head.value>target){
                if(bigH == null){
                    bigH = head;
                    bigT = head;
                }else{
                    bigT.next = head;
                    bigT = head;
                }
            }else{
                if(equalH == null){
                    equalH = head;
                    equalT = head;
                }else{
                    equalT.next = head;
                    equalT = head;
                }
            }
            head = next;
        }
        //处理返回关系
        if(smallT!=null){
            smallT.next = equalT==null?  bigH: equalH;
        }
       /* if(smallT !=null){
            smallT.next = equalH;
            equalT = equalT==null?smallT:equalT;//如果et为空那么eh也是空
        }*/
        if(equalT!=null){
            equalT.next = bigH;
        }
        return smallH!=null?smallH:equalH!=null?equalH:bigH;
    }

    /**
     * 利用八个节点作为变量完成
     * @param head
     * @param target
     * @return
     */
    private static Node someVar(Node head , int target) {
       Node sh = null;
       Node st = null;
       Node eh = null;
       Node et = null;
       Node bh = null;
       Node bt = null;
       while(head!=null){
           Node next = head.next;
           head.next = null;
           if(head.value<target){
               if(sh==null){
                   sh = head;
                   st = head;
               }else{
                   st.next = head;
                   st = head;
               }
           }else if(head.value==target){
               if(eh==null){
                   eh = head;
                   et = head;
               }else{
                   et.next = head;
                   et =head;
               }
           }else{
               if(bh==null){
                   bh = head;
                   bt = head;
               }else{
                   bt.next = head;
                   bt = head;
               }
           }
           head= next;
       }
       //处理返回关系
        if(st !=null){
            st.next = eh;
            et = et==null?st:et;//如果et为空那么eh也是空
        }
        if(et!=null){
            et.next = bh;
        }
        return sh!=null?sh:eh!=null?eh:bh;

    }

    /**
     * 利用node数组然后做partition完成
     * @param head
     * @param target
     * @return
     */
          private static Node listPartition1(Node head , int target) {
       if(head==null || head.next==null){
           return head;
       }
       Node cur = head;
       int i = 0;
       while(cur!=null){
           i++;
           cur = cur.next;
       }
        Node[] nodes = new Node[i];
       cur = head;
       int index =0;
       while(cur!=null){
           nodes[index++] = cur;
           cur = cur.next;
       }
       arrPartition(nodes,target);

       for(i = 1;i<nodes.length;i++){
           nodes[i-1].next = nodes[i];
       }
        nodes[i - 1].next = null;
       return nodes[0];
    }
    private static Node listPartition2(Node head , int target) {
       if(head==null || head.next==null) {
           return head;
       }
       int size  = 0;
       Node cur = head;
       while(cur!=null){
           size++;
           cur = cur.next;
       }
        Node[] nodes = new Node[size];
       cur = head;
       int i = 0;
       while(cur!=null){
           nodes[i++] = cur;
           cur = cur.next;
       }
       arrPartition2(nodes,target);
       int j = 0;
       for( ;j<nodes.length-1;j++){
           nodes[j].next = nodes[j+1];
       }
       nodes[j].next = null;
       return nodes[0];
    }

    /**
     * 对node数组根据target值进行partition操作
     * @param nodes
     * @param target
     */
    private static void arrPartition(Node[] nodes, int target) {
       int less = -1;
       int more = nodes.length;
       int i = 0;
       while(i<more){
          if(nodes[i].value<target){
            swap(nodes,++less,i++);
          }else if(nodes[i].value>target){
              swap(nodes,--more,i);
          }else{
              i++;
          }
      }

    }
    private static void arrPartition2(Node[] nodes, int target) {
        int less = -1;
        int more = nodes.length;
        int i = 0;
        while(i<more){
            if(nodes[i].value<target){
                swap(nodes,++less,i++);
            }else if(nodes[i].value>target){
                swap(nodes,--more,i);
            }else{
                i++;
            }
        }
    }

    private static void swap(Node[] nodes, int i, int j) {
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;

    }

    /**
     * 打印链表
     * @param head
     */
    private static void printLinkedList(Node head ) {
        if(head == null){
            return;
        }
        while(head!=null){
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();

    }
    

}
