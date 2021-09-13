package MiddleOne.classSix;

import java.util.Map;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/29 0029 21:28
 * 给定一个整型矩阵，返回子矩阵的最大累计和。
 */
public class GetMaxValueOfSubMartix {
    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
      /*  int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i != m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;*/

        int max = 0;
        int cur = 0;
        int[] s = null;
        for(int i=0;i<m.length;i++){
            s = new int[m[0].length];
            for(int j=i;j<m.length;j++){
                cur = 0;
                for(int k=0;k<s.length;k++){
                    s[k] += m[j][k];
                    cur+=s[k];
                    max = Math.max(max,cur);
                    if(cur<=0){
                        cur=0;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(maxSum(matrix));

    }
}
