package exerciseOne.矩阵;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/3 0003 15:30
 * 0 1 2 3
 * 4 5 6 7
 * 8 9 10 11
 * 打印顺序为：0 1 4 8 5 2 3 6 9 10 7 11
 */
public class ZigZagPrint {
    public static void main(String[] args) {
      int[][] martix =  new int[][]{
            {0 ,1, 2 ,3},
            {4 ,5, 6, 7},
            {8 ,9, 10 ,11}
        };
      int N = martix.length-1;
      int M = martix[0].length-1;
      int a=0;
      int b=0;
      int c=0;
      int d=0;
      boolean flag = false;
      while(a<=N){
          print(a,b,c,d,martix,flag);
          a = b==M?a+1:a;
          b = b==M?b:b+1;
          d = c==N?d+1:d;
          c = c==N?c:c+1;
          flag=!flag;
      }
    }

    /**
     * true 是从ab->cd 往下
     * false 是cd->ab  往上
     * @param a
     * @param b
     * @param c
     * @param d
     * @param martix
     * @param flag
     */
    private static void print(int a, int b, int c, int d, int[][] martix, boolean flag) {
        if (flag){//ab->cd
            int curR = a;
            int curC = b;
            while(curR<=c && curC>=d){
                System.out.print(martix[curR++][curC--]);
            }

        }else{//cd->ab
            int curR = c;
            int curC = d;
            while(curR>=a && curC<=b){
                System.out.print(martix[curR--][curC++]);
            }
        }

    }
}
