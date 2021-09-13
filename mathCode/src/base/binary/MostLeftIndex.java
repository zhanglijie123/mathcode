package base.binary;

import java.util.Arrays;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/3 0003 3:04
 * 比如 111  2222 333 789  target:2
 *     返回下标即左边边的2的下标3
 */
public class MostLeftIndex {

    public static void main(String[] args) {

        int[] ints = {1, 212, 41, 232,232,400,400,300,212,232};
        Arrays.sort(ints);
       /* for (int anInt : ints) {
            System.out.println(anInt);
        }*/
        int index =  findMostLeft(ints,232);
        int index2 =  findMostLeft2(ints,232);
        System.out.println(index+"值为"+ints[index]);
        System.out.println(index2+"值为"+ints[index2]);
    }

    private static int findMostLeft(int[] ints, int value) {
        if(ints==null || ints.length==0){
            return -1;
        }
        int l = 0;
        int r = ints.length-1;
        int mid = l+((r-l)>>1);
        while(l<r){
            if(ints[mid]>=value){
                r = mid;
                mid = l+((r-l)>>1);
            }else{
                l = mid+1;
                mid = l+((r-l)>>1);
            }
        }
        return mid;

    }
    private static int findMostLeft2(int[] ints, int value) {
       int l = 0;
       int r = ints.length-1;
       int mid = l+((r-l)>>1);
       while(l<r){
           if(ints[mid]>=value){
               r = mid;
               mid = l+((r-l)>>1);
           }else{
               l = mid+1;
               mid = l+((r-l)>>1);
           }
       }
       return mid;

    }


}
