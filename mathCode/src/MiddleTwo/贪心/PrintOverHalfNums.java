package MiddleTwo.贪心;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/2 0002 14:15
 * 打印超过次数一半的数字：
 *
 */
public class PrintOverHalfNums {
    public int MoreThanHalfNum_Solution(int [] array) {
        Integer cond = null;//候选人
        int HP = 0;//血量
        for(int i=0;i<array.length;i++){
            if(HP==0){
                cond = array[i];
                HP++;
            }else if(cond ==array[i]){
                HP++;
            }else{
                HP--;
            }
        }
        if(HP<=0){
            System.out.println("没有这样的数");
            return 0;
        }
        int time =0;
        for(int i=0;i<array.length;i++){
            if(array[i]==cond){
                time++;
            }
        }
        if(time> (int)array.length/2){
            return cond;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,2,2,2,5,4,2};
        PrintOverHalfNums printOverHalfNums = new PrintOverHalfNums();
        int i = printOverHalfNums.MoreThanHalfNum_Solution(arr);
        System.out.println(i);
    }
}
