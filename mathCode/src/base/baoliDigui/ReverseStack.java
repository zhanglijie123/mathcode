package base.baoliDigui;

import java.util.Stack;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/26 0026 12:35
 * 使用递归 不用已有的数据结构 完成逆序一个栈
 */
public class ReverseStack {


    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 返回栈底元素，上面的压下来   比如 | 1|     |1|
     *                             | 2|  -》 |2|  and 3
     *                             | 3|
     * @param stack
     * @return
     */
    private static int f(Stack<Integer> stack) {
        Integer result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = f(stack);
            stack.push(result);
            return last;
        }

    }
}
