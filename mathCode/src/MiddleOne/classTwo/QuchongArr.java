package MiddleOne.classTwo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/16 0016 0:14
 * 给定一个数组arr，求差值为k的去重数字对
 * 比如 2 4 5 9 k为2 
 * 结果就是2，4
 */
public class QuchongArr {
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,5,9,56};
        int k = 2;
        HashMap<Integer,Integer> res = getDisByK(arr,k);
        for (Integer integer : res.keySet()) {
            System.out.println(integer+", "+res.get(integer));
        }
    }

    private static HashMap<Integer, Integer> getDisByK(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]+k)){
                res.put(arr[i],arr[i]+k);
            }
        }
        return res;
    }
}
