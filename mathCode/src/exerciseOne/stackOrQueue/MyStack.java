package exerciseOne.stackOrQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 11:56
 */
public class MyStack<V> {
   public Queue<V>  queue;
   public Queue<V>  help;
   public MyStack(){
       queue = new LinkedList<V>();
       help = new LinkedList<V>();
   }
   public void push(V v){
       queue.add(v);
   }
   public V pop(){
       if(queue.isEmpty()){
           throw new RuntimeException("stack is Empty");
       }
       while(queue.size()>1){
           help.add(queue.poll());
       }

       V v =  queue.poll();
       swap();
       return v;
   }

    private void swap() {
        Queue<V> temp = this.queue;
        this.queue = help;
        help = temp;
    }

    public V peek(){
        if(queue.isEmpty()){
            throw new RuntimeException("stack is Empty");
        }
        while(queue.size()>1){
            help.add(queue.poll());
        }
        V v =  queue.poll();
        help.add(v);
        swap();
        return v;
    }
}
