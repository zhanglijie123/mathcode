package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/29 0029 23:55
 *
 * Bob的生存概率 【题目】
 * 给定五个参数n,m,i,j,k。表示在一个N*M的区域，Bob处在(i,j)点，每次Bob等概率的向上、 下、左、右四个方向移动一步，
 * Bob必须走K步。如果走完之后，Bob还停留在这个区域上， 就算Bob存活，否则就算Bob死亡。请求解Bob的生存概率，返回字符串表示分数的方式。
 */
public class BobDie {
    public static void main(String[] args) {
        int nums =  getSaveNums(10,10,3,2,5);
        System.out.println(nums+" ===>生存数");
        double saveRate =  (nums/(Math.pow(4,5)));
        System.out.println(saveRate+"  ===>生存率");

    }

    private static int getSaveNums(int N, int M, int x, int y, int K) {
        if(x<0 || x> N || y<0 ||y>M){
            return 0;
        }
        if(K == 0){
            if(x<0 || x> N || y<0 ||y>M){
                return 0;
            }else{
                return 1;
            }
        }
        return getSaveNums(N,M,x+1,y,K-1)+
          getSaveNums(N,M,x-1,y,K-1)+
          getSaveNums(N,M,x,y+1,K-1)+
          getSaveNums(N,M,x ,y-1,K-1) ;
    }
}
