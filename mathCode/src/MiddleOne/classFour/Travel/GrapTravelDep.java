package MiddleOne.classFour.Travel;

import java.util.HashSet;
import java.util.List;

import base.map.base.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 16:43
 */
public class GrapTravelDep {
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
        //深度遍历
        dfs(head);
    }

    private static void dfs(Node head) {
        System.out.println("图的深度遍历");
        MyStack<Node> stack = new MyStack<>();
        stack.push(head);
        HashSet<Node> set  = new HashSet<>();
        set.add(head);
        System.out.print(head.value);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            List<Node> nexts = pop.nexts;
            for (Node next : nexts) {
                if(!set.contains(next)){
                    System.out.print(next.value);
                    stack.push(pop);
                    stack.push(next);
                    set.add(next);
                }
            }
        }
    }
}
