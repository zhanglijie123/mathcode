package exerciseOne.矩阵;

import java.util.ArrayList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/3 0003 13:56
 * 旋转矩阵：
 * 给定一个正方形矩阵，只用有限几个变量，实现矩阵中每个位置的数顺时针转动 90度，比如如下的矩阵
 * 0  1  2  3
 * 4  5  6  7
 * 8  9 10  11
 * 12 13 14 15
 * 矩阵应该被调整为：
 * 12 8 4 0
 * 13 9 5 1
 * 14 10 6 2
 * 15 11 7 3
 */
public class XuanZhuanJz {
    public static void main(String[] args) {
        int[][] martix = new int[][] {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}};
        int N = martix.length;
        int M = martix[0].length;
        int a = 0;
        int b = 0;
        int c = N - 1;
        int d = M - 1;
        while (a <= c && b <= d) {
            reload(martix, a++, b++, c--, d--);
        }
        for (int[] ints : martix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }

    /**
     * @param martix
     * @param a
     * @param b
     * @param c
     * @param d martix[a][b+i]
     * martix[a+i][d]
     * martix[c][d-i]
     * martix[c-i][b]
     */
    private static void reload(int[][] martix, int a, int b, int c, int d) {
        for (int i = 0; i < c - a; i++) {
            int temp = martix[a][b + i];
            martix[a][b + i] = martix[c - i][b];
            martix[c - i][b] = martix[c][d - i];
            martix[c][d - i]  =  martix[a + i][d];
            martix[a + i][d] =   temp ;

        }
    }

}
