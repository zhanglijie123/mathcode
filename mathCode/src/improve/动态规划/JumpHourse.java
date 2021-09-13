package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/29 0029 23:40
 * 象棋 马跳
 * 问题描述：
 * 请同学们自行搜索或者想象一个象棋的棋盘，然后把整个棋盘放入第一象限，棋盘的最左下 角是(0,0)位置。
 * 那么整个棋盘就是横坐标上9条线、纵坐标上10条线的一个区域。给你三个 参数，x，y，k，返回如果“马”从(0,0)位置出发，必须走k步，
 * 最后落在(x,y)上的方法数 有多少种？
 */
public class JumpHourse {
    public static void main(String[] args) {
        int ways = getWays(1,2,1);//从(1,2)位置达到（0，0）走一步能完成的方法数
        System.out.println(ways);
        int ways2 = getWaysBy3D(1,2,1);
        System.out.println(ways2);
    }

    /**
     * 通过动态规划成严格表结构完成  建立三维表
     * @param x
     * @param y
     * @param depth
     * @return
     *
     * 注意表结构是先构建表 然后返回x,y,depth坐标的值即可 表得大小维度要取满
     */
    private static int getWaysBy3D(int x, int y, int depth) {
        if(x<0 || x>8 ||y<0 || y>9 || depth<0){
            return 0;
        }
        int[][][] dp = new int[9][10][depth+1];
        dp[0][0][0] = 1;
        for(int h = 1;h<=depth;h++){
            for(int i = 0;i<9;i++){
                for(int j =0;j<10;j++){
                    dp[i][j][h] += getValue(dp,i-1,j-2,h-1);
                    dp[i][j][h] += getValue(dp,i-1,j+2,h-1);
                    dp[i][j][h] += getValue(dp,i+1,j-2,h-1);
                    dp[i][j][h] += getValue(dp,i+1,j+2,h-1);
                    dp[i][j][h] += getValue(dp,i+2,j-1,h-1);
                    dp[i][j][h] += getValue(dp,i+2,j+1,h-1);
                    dp[i][j][h] += getValue(dp,i-2,j+1,h-1);
                    dp[i][j][h] += getValue(dp,i-2,j-1,h-1);
                }
            }
        }
        return dp[x][y][depth];
    }

    private static int getValue(int[][][] dp, int x, int y, int h) {
        if(x<0 || x>8 ||y<0 || y>9){
            return 0;
        }
        return dp[x][y][h];
    }

    /**
     * 从 0,0走k步能达到目标第x,y的方法有多少种？ x,y不能超过8和9
     * 可以反转成从x,y回到0，0走k步有多少走法这种思路
     * @param x
     * @param y
     * @param k
     * @return
     */
    private static int getWays(int x, int y, int k) {
        if(x<0 || x>8 ||y<0 || y>9  || k<0){
            return 0;
        }
        if(k==0){
            return (x==0 && y==0)?1:0;
        }
        return getWays(x-1,y-2,k-1) +
         getWays(x-1,y+2,k-1) +
         getWays(x+1,y-2,k-1) +
         getWays(x+1,y+2,k-1) +
         getWays(x+2,y-1,k-1) +
         getWays(x+2,y+1,k-1) +
         getWays(x-2,y+1,k-1) +
         getWays(x-2,y-1,k-1) ;
    }
}
