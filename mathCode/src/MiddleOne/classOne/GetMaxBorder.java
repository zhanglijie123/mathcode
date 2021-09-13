package MiddleOne.classOne;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/14 0014 23:47
 * 给定一个N*N的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边 长长度。
 * 例如:
 * 01111
 * 01001
 * 01001
 * 01111
 * 01011
 * 其中边框全是1的最大正方形的大小为4*4，所以返回4。
 *
 * 对于  0001
 *      0000
 *      1000 这个最长的是1
 *
 *
 *      https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 *      这个扩展题不能用此方法做
 *
 */
public class GetMaxBorder {
    public static void main(String[] args) {
          int[][] matrix = {
            {0,1,1,1,1},
            {0,1,0,0,1},
            {0,1,0,0,1},
            {0,1,1,1,1},
            {0,1,0,1,1}};

        System.out.println(getMaxBorder(matrix));
        /*System.out.println("test");
         for (int i=0;i<100;i++){
            int[][] matrix = generateRandom01Matrix(7, 8);
            if(getMaxSize(matrix)!=getMaxBorder(matrix)){
                System.out.println("不对哦");
            }
        }*/
    }

    private static int getMaxBorder(int[][] matrix) {
        int maxBorder = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        //建立辅助数组
        int[][] downToUp = getDTU(matrix);
        int[][] rightToLeft = getRTL(matrix);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                //上面的两个for循环是固定一个点，下面的一个for循环就是边长开始
                for(int border=1;border<=(Math.min(N-i,M-j));border++){
                    //验证从此边长出发的边是否数字都是1，是则满足，求出最大值.首先可以借助辅助数组
                    if(downToUp[i][j]>=border && rightToLeft[i][j]>=border &&
                     downToUp[i][j+border-1]>=border && rightToLeft[i+border-1][j]>=border){
                        maxBorder = Math.max(maxBorder,border);
                    }

                }
            }
        }
        return maxBorder;
    }

    private static int[][] getRTL(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] RES = new int[N][M];

        for(int r=0;r<=N-1;r++){
            if(matrix[r][M-1]==1){
                RES[r][M-1] =1;
            }
        }
        for(int row = N-1;row>=0;row--){
            for(int col=M-2;col>=0;col--){
              if(matrix[row][col]==1){
                  RES[row][col] = RES[row][col+1]+1;
              }else{
                  RES[row][col] = 0;
              }
            }
        }
        return RES;
    }

    private static int[][] getDTU(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] RES = new int[N][M];
        for(int c=0;c<=M-1;c++){
            if(matrix[N-1][c]==1){
                RES[N-1][c] =1;
            }
        }
        for(int col=M-1;col>=0;col--){
            for(int row = N-2;row>=0;row--){
                if(matrix[row][col]==1){
                    RES[row][col] = RES[row+1][col]+1;
                }else{
                    RES[row][col] = 0;
                }
            }
        }
        return RES;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getMaxBorder1(int[][] matrix) {
        int borderLen = Integer.MIN_VALUE;
        //生产从左往右是连续是1的记录  比如 10111 对应的是10321
        int[][] rToL = getRightToLeftIsOne(matrix);
        /**
         * 生产从下往上连续是1的记录 比如 0 对应的是 0
         *                           1        2
         *                           1        1
         */

        int[][] dTou = getDownToUpIsOne(matrix);


        int R= matrix.length;
        int C = matrix[0].length;
        printMatrix(dTou);
        printMatrix(rToL);
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                //枚举边长 从1开始
                for(int border=1;border<=Math.min(R-i,C-j)+1;border++){
                    //验证以（i，j)为坐标，边长是border围起来的边他们的值在原始矩阵中是否都是1。是1就合格
                    int r = border+i;
                    int c = j+border;
                    if(rToL[i][j]>=border && dTou[i][j]>=border && rToL[r-1][j]>=border && dTou[i][c-1]>=border){
                        borderLen = Math.max(borderLen,border);
                    }
                }
            }
        }

        return borderLen;
    }

    private static int[][] getDownToUpIsOne(int[][] matrix) {
        int R= matrix.length;
        int C = matrix[0].length;
        int[][] temp = new int[R][C];
        for(int i=C-1;i>=0;i--){
            if(matrix[R-1][i]==1){
                temp[R-1][i] = 1;
            }
        }

        for(int c = C-1;c>=0;c--){
            for(int r = R-2;r>=0;r--){
                if(matrix[r][c]==1){
                    temp[r][c] = temp[r+1][c]+1;
                }else{
                    temp[r][c] = 0;
                }
            }
        }
        return temp;
    }

    private static int[][] getRightToLeftIsOne(int[][] matrix) {
        int R= matrix.length;
        int C = matrix[0].length;
        int[][] temp = new int[R][C];
        for(int i=R-1;i>=0;i--){
            if( matrix[i][C-1]==1){
                temp[i][C-1] =1;
            }
        }

        for(int r = R-1;r>=0;r--){
            for(int c = C-2;c>=0;c--){
              if(matrix[r][c]==1){
                  temp[r][c] = temp[r][c+1]+1;
              }else{
                  temp[r][c] = 0;
              }
            }
        }
        return temp;
    }

    public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
        int[][] res = new int[rowSize][colSize];
        for (int i = 0; i != rowSize; i++) {
            for (int j = 0; j != colSize; j++) {
                res[i][j] = (int) (Math.random() * 2);
            }
        }
        return res;
    }

    public static void setBorderMap(int[][] m, int[][] right, int[][] down) {
        int r = m.length;
        int c = m[0].length;
        if (m[r - 1][c - 1] == 1) {
            right[r - 1][c - 1] = 1;
            down[r - 1][c - 1] = 1;
        }
        for (int i = r - 2; i != -1; i--) {
            if (m[i][c - 1] == 1) {
                right[i][c - 1] = 1;
                down[i][c - 1] = down[i + 1][c - 1] + 1;
            }
        }
        for (int i = c - 2; i != -1; i--) {
            if (m[r - 1][i] == 1) {
                right[r - 1][i] = right[r - 1][i + 1] + 1;
                down[r - 1][i] = 1;
            }
        }
        for (int i = r - 2; i != -1; i--) {
            for (int j = c - 2; j != -1; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

    public static int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m, right, down);
        for (int size = Math.min(m.length, m[0].length); size != 0; size--) {
            if (hasSizeOfBorder(size, right, down)) {
                return size;
            }
        }
        return 0;
    }

    public static boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for (int i = 0; i != right.length - size + 1; i++) {
            for (int j = 0; j != right[0].length - size + 1; j++) {
                if (right[i][j] >= size && down[i][j] >= size
                    && right[i + size - 1][j] >= size
                    && down[i][j + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }



}

