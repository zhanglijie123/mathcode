package MiddleTwo.贪心;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/31 0031 13:11
 * 给定一个整型数组arr和一个大于1的整数k。已知arr中只有1个数出现了一次，其他的数出现k次，请返回出现了1次的数。
 * 7 3
 * 5 4 1 1 5 1 5
 * 数组长度为7 其他数出现3次 只有4出现一次 返回4
 */
public class HappenOnlyOneNums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = scanner.nextInt();
        }
        int res = getOnlyOneNum(arr,K);
        System.out.println(res);
    }

    /**
     * 数组中只有一个数出现一次 其他数出现K次
     * @param arr
     * @return
     */
    private static int getOnlyOneNum(int[] arr,int K) {
        int res = 0;
        if(K%2 == 0){
            for (int i : arr) {
                res  = res^i;
            }
        }
        if(K%2==1){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                if(!map.containsKey(i)){
                    map.put(i,1);
                }else{
                    map.put(i,map.get(i)+1);
                }
            }
            for (Integer integer : map.keySet()) {
                if(map.get(integer)==1){
                    res = integer;
                }
            }
        }
        return res;


    }
}
