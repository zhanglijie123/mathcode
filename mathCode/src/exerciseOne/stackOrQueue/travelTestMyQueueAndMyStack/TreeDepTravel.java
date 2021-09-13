package exerciseOne.stackOrQueue.travelTestMyQueueAndMyStack;

import java.util.Stack;

import MiddleOne.classFour.Travel.MyStack;
import MiddleOne.classFour.Travel.TreeTravelDep;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/5 0005 14:32
 * 先序遍历
 * 5321487610911
 * 中序遍历
 * 1234567891011
 * 后序遍历
 * 1243679111085
 */
public class TreeDepTravel {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
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
       if(head == null){
           return;
       }
        System.out.println("后续遍历");
        MyStack<Node> stack = new MyStack<>();
        MyStack<Node> stack1 = new MyStack<>();
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
            System.out.print(stack1.pop().value);
        }
    }

    private static void inOrderUnRecur(Node head) {
        if(head == null){
            return;
        }
        System.out.println("中序遍历");
        MyStack<Node> stack = new MyStack<>();
        if(head!=null){
            while(head!=null || !stack.isEmpty()){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    Node pop = stack.pop();
                    System.out.print(pop.value);
                    head = pop.right;
                }
            }
        }
    }

    private static void preOrderUnRecur(Node head) {
        if(head == null){
            return;
        }
        MyStack<Node> stack = new MyStack<>();
        stack.push(head);
        System.out.println("先序遍历");
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.value);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
    }

}
