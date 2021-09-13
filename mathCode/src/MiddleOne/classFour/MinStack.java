package MiddleOne.classFour;

import java.util.Stack;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 17:24
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素
 * 的操作。
 * 要求：1.pop、push、getMin操作的时间复杂度都是O(1)；2.设计的栈类型可以
 * 使用现成的栈结构
 */
public class MinStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.getMin());
        System.out.println(stack.pop()  );
        System.out.println(stack.getMin());
    }
    public static class MyStack<V extends  Integer>{
        public Stack<V> dataStack;
        public Stack<V> minStack;
        public MyStack(){
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }
        public void push(V v){
            if(this.minStack.isEmpty()){
                minStack.push(v);
            }else if(minStack.peek().compareTo(v)>=0){
                minStack.push(v);
            }else{
                minStack.push(minStack.peek());
            }
            dataStack.push(v);
        }
        public V pop(){
            if(dataStack.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            minStack.pop();
            return dataStack.pop();
        }
        public V peek(){
            if(dataStack.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return dataStack.peek();
        }
        public V getMin(){
            if(dataStack.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return minStack.peek();
        }
    }

}
