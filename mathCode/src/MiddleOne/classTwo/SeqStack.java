package MiddleOne.classTwo;

import java.util.Stack;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/16 0016 14:48
 * 仅仅借助另外一个statck，将原先stack的元素拍成有序
 * 比如借助stack1将statck 的元素    变成
 *                           2，        1
 *                           3，         2
 *                           1，         3
 *                           55         55
 */
public class SeqStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(55);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        seqStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static  void seqStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
