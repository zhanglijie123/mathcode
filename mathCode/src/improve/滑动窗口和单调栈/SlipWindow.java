package improve.滑动窗口和单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/6 0006 22:18
 */
public class SlipWindow {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        Deque<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            //弹出
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            //放入
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 4, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

