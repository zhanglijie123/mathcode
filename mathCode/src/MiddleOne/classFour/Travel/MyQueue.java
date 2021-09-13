package MiddleOne.classFour.Travel;

import java.util.Stack;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 11:56
 */
public class MyQueue<V> {
    public Stack<V> dataStack;
    public Stack<V> daoStack;
    public MyQueue(){
        dataStack = new Stack<V>();
        daoStack = new Stack<V>();
    }
    public boolean isEmpty(){
        return dataStack.isEmpty() && daoStack.isEmpty();
    }
    public void add(V v){
        if(daoStack.isEmpty()){
            dao();
        }
        dataStack.push(v);
    }
    public V poll(){
        if( dataStack.isEmpty() && daoStack.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        if(daoStack.isEmpty()){
            dao();
        }
        return daoStack.pop();
    }
    public V peek(){
        if( dataStack.isEmpty() && daoStack.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        if(daoStack.isEmpty()){
            dao();
        }
        return daoStack.peek();
    }

    private void dao() {
        while(!dataStack.isEmpty()){
            daoStack.push(dataStack.pop());
        }
    }
}
