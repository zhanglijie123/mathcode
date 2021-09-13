package improve.滑动窗口和单调栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/27 0027 16:23
 */
public class SlipCp {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 4, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));
    }

    private static void printArray(List<Integer> arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static List<Integer> getMaxWindow(int[] arr, int w) {
        if(arr==null || arr.length==0 || arr.length<w){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 0 ; i<arr.length;i++){
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(dq.peekFirst() == i-w){
                //过期的左边，为3时候左边已经过期了可以删了
                dq.pollFirst();
            }
            if(i -w>=-1){
                //窗口形成,从下标2开始
                res.add(arr[dq.peekFirst()]);
            }
        }
        return res;
    }
}
