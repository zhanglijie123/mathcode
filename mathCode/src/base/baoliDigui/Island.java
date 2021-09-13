package base.baoliDigui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/6 0006 14:14
 * 岛屿问题
 *  001010
 *  111010
 *  100100
 *  000000
 * 这个矩阵中有三个岛
 *
 * 使用感染的方式完成
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class Island {
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
      /*  int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));*/

        System.out.println(3*0.1 == 0.3  );
    }
    }
