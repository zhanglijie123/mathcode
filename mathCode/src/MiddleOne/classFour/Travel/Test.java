package MiddleOne.classFour.Travel;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 21:49
 */
public class Test {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println(">>>>>>>>>>>>>>>");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
