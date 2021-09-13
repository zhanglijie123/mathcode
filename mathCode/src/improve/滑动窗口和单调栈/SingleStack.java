package improve.滑动窗口和单调栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/7 0007 18:15
 */
public class SingleStack {
    public static int[][] getNearMoreNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }




    public static int[][] getNearMoreCp(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek().get(stack.peek().size()-1)]<arr[i]){//  比较时候用arr[stack.peek().get(0)  arr[stack.peek().get(stack.peek().size()-1)] 或者  取出lastIndex时候使用size()-1

                List<Integer> pop = stack.pop();
                int lastIndexOfTop = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
                for (Integer curP : pop) {
                    res[curP][0] = lastIndexOfTop;
                    res[curP][1] = i;
                }

            }
            if(!stack.isEmpty() && arr[stack.peek().get(stack.peek().size()-1)]==arr[i]){
                stack.peek().add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        //遍历完就需要弹出栈中还有的
        while(!stack.isEmpty()){
            List<Integer> pop = stack.pop();
            int lastIndexOfTop = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
            for (Integer cPop : pop) {
                res[cPop][1] = -1;
                res[cPop][0] = lastIndexOfTop;
            }
        }
        return res;
    }
    /**
     * 栈底的值大于栈顶
     * @param arr
     * @return
     */
    public static int[][] getNearMore(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[ stack.peek().size()-1] < arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                    stack.peek().size()-1 );
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            //正常进入情况不需要弹出里面小的
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        //不需要加入了将栈清空处理
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {5,11,1,1,3};
        int[][] nearLessNoRepeat = getNearMoreCp(arr);
        for (int ints : nearLessNoRepeat[2]) {
            System.out.println(ints);
        }

    }
}
