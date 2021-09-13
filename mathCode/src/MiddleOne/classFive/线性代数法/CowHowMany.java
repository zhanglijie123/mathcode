package MiddleOne.classFive.线性代数法;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 20:54
 * 一个农场，有一个母牛，农场通过生育技术人工授精让母牛只能生母牛而不让生公牛。母牛从第二年开始生母牛，对于新生的牛需要等过了三年才能生母牛
 * 假设牛不会死，问n年后农场有多少只母牛？
 *
 * 第一年 ：母牛A                                 1只
 * 第二年： 母牛A生B                              2只
 * 第三年： 母牛A生C，A，B                        3只
 * 第四年：母牛A生D，A,B,C                       4只
 * 第五年：母牛A生E,B生F，A,B,C,D                6只
 * 第六年：母牛A生G,B生H，C生I，A,B,C,D,E,F      9只
 *                                          13
 *                                          19
 *
 *
 * 公式：F(N) = F(N-1)+F(N-3)
 *
 */
public class CowHowMany {
    public static void main(String[] args) {
       int year =8;
       int sum = getHowManyCow(year);
       System.out.println(sum);
    }

    private static int getHowManyCow(int year) {
        if(year<=3){
            return  year;
        }
        int[][] base = new int[][]{
            {1,1,0},
            {0,0,1},
            {1,0,0}
        };
        int[][]res = martixPow(base,year-3);
        return 3*res[0][0]+2*res[1][0]+1*res[2][0];
    }

    private static int[][] martixPow(int[][] base, int n) {
        int[][] res = new int[base.length][base[0].length];
        for(int i=0;i<res.length;i++){
            res[i][i] = 1;//单位矩阵
        }
        int[][] t = base;
        for(;n!=0;n>>=1){
            if((n&1)!=0){
                res = multMaritx(res,t);
            }
            t = multMaritx(t,t);
        }
        return res;
    }

    private static int[][] multMaritx(int[][] t, int[][] t1) {
        int[][] res = new int[t.length][t1[0].length];
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t1[0].length;j++){
                for(int k=0;k<t1.length;k++){
                    res[i][j] += t[i][k]*t1[k][j];
                }
            }
        }
        return res;
    }
}
