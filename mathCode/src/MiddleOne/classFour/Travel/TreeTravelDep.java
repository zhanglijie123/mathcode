package MiddleOne.classFour.Travel;

import java.util.Scanner;

import base.tree.NodiguiBianli;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 16:43
 */
public class TreeTravelDep {
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
        System.out.println("后序遍历");
        MyStack<Node> stack1 = new MyStack<>();
        MyStack<Node> stack2 = new MyStack<>();
        stack1.push(head);
        while(!stack1.isEmpty()){
            Node pop = stack1.pop();
            stack2.push(pop);
            if(pop.left!=null){
                stack1.push(pop.left);
            }
            if(pop.right!=null){
                stack1.push(pop.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().value);
        }
    }

    private static void inOrderUnRecur(Node head) {
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
        System.out.println("先序遍历");
        MyStack<Node> stack = new MyStack<>();
        stack.push(head);
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


