package MiddleOne.classFour.Travel;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 11:56
 */
public class MyStack<V> {
    public Queue<V> queue;
    public Queue<V> help;

    public MyStack( ) {
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }
    public boolean isEmpty(){
        return queue.isEmpty() && help.isEmpty() ;
    }
    public void push(V v){
        queue.add(v);
    }
    public V peek(){
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while(queue.size()>1){
            help.add(queue.poll());
        }
        V res = queue.poll();
        help.add(res);
        swap();
        return res;
    }
    public V pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while(queue.size()>1){
            help.add(queue.poll());
        }
        V res = queue.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<V> temp = queue;
        queue = help;
        help = temp;
    }
}
