package base.map.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 13:48
 * 广度遍历图 -- queue +set
 */
public class Width {
    public static void bfs(Node node) {
       if(node == null){
           return;
       }
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            for (Node next : poll.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
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

    private static void bfs1(Node head) {
        if(head==null){
            return;
        }
        HashSet<Node> set = new HashSet<>();
        set.add(head);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            for (Node next : poll.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }

    }
}
