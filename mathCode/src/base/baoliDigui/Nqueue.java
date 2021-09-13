package base.baoliDigui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/26 0026 15:31
 *  n皇后 -- 对于n皇后加速后面回过头再研究
 *
 *
 *   int[] rs = new int[]{0,1,0,0,2,10,4,40,92,352,724,2680};
 *    return rs[n];
 */
public class Nqueue {
    public static void main(String[] args) {
         int res =getNum(4);
        System.out.println(res);
    }

    private static int getNum(int n) {
        if(n<1 || n>32){
            return 0;
        }
        int limit= n == 32?-1:(1<<n)-1;
        return process(limit,0,0,0);
    }

    private static int process(int limit, int col, int leftXie, int rightXie) {
        if(col==limit){//base case。当全部位都是满了就是最后一行了
            return 1;
        }
        int mostRight = 0;
        int pos = limit&(~(col|leftXie|rightXie));//这个就是当前行允许放皇后的下标，为1可以为0不行
        int res = 0;
        while(pos!=0){
            mostRight=pos&(~pos+1);//最右边那位位1,也就是从最右边位开始尝试
            pos=pos-mostRight;
            res+=process(limit,(col|mostRight),(leftXie|mostRight)<<1,(rightXie|mostRight)>>>1);
        }
        return res;

    }
}
