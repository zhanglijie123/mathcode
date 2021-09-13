package base.map.others;

import java.nio.file.NotDirectoryException;
import java.util.HashSet;
import java.util.Stack;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 13:48
 * 深度遍历图  --栈 +set
 */
public class Depth {
    public static void dfs(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(head);
        set.add(head);
        System.out.println(head.value);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if(!set.contains(next)){
                    System.out.println(next.value);
                    stack.push(pop);
                    stack.push(next);
                    set.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        base.map.others.Node head = new base.map.others.Node(1);
        base.map.others.Node node2 = new base.map.others.Node(2);
        base.map.others.Node node3 = new base.map.others.Node(3);
        base.map.others.Node node4 = new base.map.others.Node(4);
        base.map.others.Node node5 = new base.map.others.Node(5);
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
        System.out.println("==========================");
        dfs2(head);
    }

    private static void dfs2(Node head) {
        if(head == null){
            return ;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        HashSet<Node> set = new HashSet<>();
        set.add(head);
        System.out.println(head.value);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if(!set.contains(next)){
                    System.out.println(next.value);
                    stack.push(pop);
                    set.add(next);
                    stack.push(next);
                }
            }
        }
    }
}
