package exerciseOne.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/3 0003 15:14
 * 用螺旋的方式打印矩阵，
 * 比如如下的矩阵 0 1 2 3
 *             4 5 6 7
 *             8 9 10 11 打印顺序为：0 1 2 3 7 11 10 9 8 4 5 6
 */
public class LuoXuanPrint {
    public static void main(String[] args) {
        int[][] martix = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int N = martix.length;
        int M = martix[0].length;
        int a =0;
        int b =0;
        int c = N-1;
        int d = M-1;
        ArrayList<Integer> res = new ArrayList<>();
        while(a<=c && b<=d){
            reloadPrint(a++,b++,c--,d--,martix,res);
        }


    }

    private static void reloadPrint1(int a, int b, int c, int d, int[][] martix, ArrayList<Integer> res) {
        if(a==c){
            int cur = b;
            while(cur<=d){
                System.out.print(martix[a][cur++]);
            }
        } else if(b==d){
            int cur = a;
            while(cur<=c){
                System.out.print(martix[cur++][b]);
            }
        }else{
            //螺旋打印
            int curR = a;
            int curC = b;
            while(curC!=d){
                System.out.print(martix[a][curC++]);
            }
            while(curR!=c){
                System.out.print(martix[curR++][curC]);
            }
            while(curC!=b){
                System.out.print(martix[c][curC--]);
            }
            while(curR!=a){
                System.out.print(martix[curR--][curC]);
            }

        }
    }

    private static void reloadPrint(int a, int b, int c, int d, int[][] martix, List<Integer> res) {
        if(a==c){
            for(int i=b;i<=d;i++){
                res.add(martix[a][i]);
            }
        }else if(b==d){
            for(int i=a;i<=c;i++){
                res.add(martix[i][b]);
            }
        }else{
            int curR = a;
            int curC =b;
            while(curC!=d){
                res.add(martix[a][curC++]);
            }
            while(curR!=c){
                res.add(martix[curR++][d]);
            }
            while(curC!=a){
                res.add(martix[c][curC--]);
            }
            while(curR!=a){
                res.add(martix[curR--][b]);
            }
        }
    }
}
