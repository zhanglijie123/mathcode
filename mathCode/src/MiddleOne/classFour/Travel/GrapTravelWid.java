package MiddleOne.classFour.Travel;



import java.util.HashSet;
import java.util.List;

import base.map.others.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 16:43
 */
public class GrapTravelWid {
    public static void bfs(Node node) {
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(node);
        System.out.println("图的宽度遍历");
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            List<Node> nexts = poll.nexts;
            for (Node next : nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }

    }




    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.nexts.add(node2);
        head.nexts.add(node3);
        head.nexts.add(node4);
        node3.nexts.add(node4);
        node4.nexts.add(node5);
        //下面几行代码是双向的图，但是也能使用在广度遍历上
        node2.nexts.add(head);
        node3.nexts.add(head);
        node4.nexts.add(head);
        node4.nexts.add(node3);
        node5.nexts.add(node4);
        //广度遍历
        bfs(head);
    }
}
