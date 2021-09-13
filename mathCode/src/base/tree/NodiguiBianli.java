package base.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.NOP;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/9 0009 13:51
 * 不使用递归完成二叉树的先序，中序后序遍历
 *
 * 注意：其中先序遍历指的是深度优先遍历
 *
 *
 * 前序遍历
 * 5321487610911
 * 中序遍历
 * 1234567891011
 * 后续遍历
 * 1243679111085
 */
public class NodiguiBianli {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

       

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        System.out.println();
        inOrderUnRecur(head);
        System.out.println();
        posOrderUnRecur(head);


    }

    private static void posOrderUnRecur(Node head) {
       if(head==null){
           return;
       }
        System.out.println("后续遍历");
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            stack1.push(pop);
            if(pop.left!=null){
                stack.push(pop.left);
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }
        }
        while(!stack1.isEmpty()){
            System.out.print(stack1.pop().value+" ");
        }
    }

    private static void inOrderUnRecur(Node head) {
        if(head==null){
            return;
        }
        System.out.println("中序遍历：");
        Stack<Node> stack = new Stack<>();
        if(head!=null){
            while(head!=null || !stack.isEmpty()){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    Node pop = stack.pop();
                    System.out.print(pop.value+" ");
                    if(pop.right!=null){
                        head = pop.right;
                    }
                }
            }
        }

    }
    /**

     * 先序遍历非递归方式
     * @param head
     */
    private static void preOrderUnRecur(Node head) {
        if(head==null){
            return ;
        }

        System.out.println("先序遍历");
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.value+" ");
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
    }
}



