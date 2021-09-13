package MiddleTwo.贪心;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/6 0006 14:01
 * 给定一个整型数组arr，再给定一个整数k，打印所有出现次数大于n/k的数，如果没有这样的数,请打印”-1“。
 *
 * 示例1
 * 输入
 * 7 7
 * 1 2 3 1 2 3 4
 * 输出
 * 1 2 3
 *
 *
 * 示例2
 * 输入
 * 4 1
 * 1 1 2 3
 * 输出
 * -1
 */
public class MoreThanNdivK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = scanner.nextInt();
        }
        List<Integer> res = printNdivK(arr, K);
        for (Integer re : res) {
            System.out.println(re);
        }

    }

    private static List<Integer> printNdivK(int[] arr, int k) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.size()<(k-1)){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],1);
                }else{
                    map.put(arr[i],map.get(arr[i])+1);
                }
            }else{
                if(map.containsKey(arr[i])){
                    map.put(arr[i],map.get(arr[i])+1);
                }else{
                    for (Integer key : map.keySet()) {
                        Integer v = map.get(key);
                        if(v==1){
                            map.remove(key);
                        }else{
                            map.put(key,v-1);
                        }
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        System.out.println("map的容量"+map.size());
        for (Integer integer : map.keySet()) {
            if(map.get(integer)<=(arr.length/k)){
                map.remove(integer);
            }
        }
        if(map.size()==0){
            System.out.println("-1");
            res.add(-1);

        }else{
            for (Integer integer : map.keySet()) {
               res.add(integer);

            }
        }
        return res;
}
}
