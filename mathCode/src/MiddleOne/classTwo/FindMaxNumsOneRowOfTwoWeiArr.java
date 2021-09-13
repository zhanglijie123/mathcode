package MiddleOne.classTwo;

import java.util.ArrayList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/1 0001 21:15
 * 基于1的扩展题：
 *     每一行数0一律放在1的左边，比如00001111
 *     也可以是没有0只有1 比如111111111
 *     那么如下：0000011
 *             0111111
 *             0000000
 *             1111111
 *             基于这个二维数组，返回含有1数量最多的行。此例子就是返回最后一行3
 *      思路：准备一个list和maxOne
 *      从右上角出发，往左走知道为0，记录改行出现1的次数的最大次数到maxOne,然后把该行的行标放到list中；
 *      然后往下方走到第二行从往左遍历，如果1的次数小于上次的更新的就不记录然后再往下一行走以此类推（思路就是如果1比之前的多更新maxOne和list)
 *      最后返回list.get(0)
 */
public class FindMaxNumsOneRowOfTwoWeiArr {
    public static void main(String[] args) {
        int[][] marix = new int[][]{
            {0,0,0,0,0,1,1 },
            {0,1,1,1,1,1,1},
            {0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1}
        };
        int row  = getMaxOneRow(marix);
        System.out.println(row);
    }

    private static int getMaxOneRow(int[][] marix) {
        int N = marix.length;
        int M = marix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int count = 0;
        int i = 0;
        int j = M-1;
        for( i=0;i<N;i++){
            while(j>=0 && marix[i][j]==1){
                count++;
                j--;
            }
            if(count>=res.get(0)){
                res.clear();
                res.add(i);
            }
            continue;
        }

        return res.get(0);
    }
}
