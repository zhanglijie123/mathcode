package improve.hash;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/25 0025 21:00
 */
public class IslandCp {
    public static void main(String[] args) {

            int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
            System.out.println(countIslands(m1));
        }


    private static int countIslands(int[][] marix) {
        if(marix==null || marix.length==0){
            return 0;
        }
         int M = marix.length;
         int N = marix[0].length;
         int res = 0;
         for(int i=0;i<M;i++){
             for(int j=0;j<N;j++){
                 if(marix[i][j] == 1){
                 res++;
                 //感染
                 infect(marix,M,N,i,j);
                 }
             }
         }
         return res;
    }

    private static void infect(int[][] marix, int m, int n, int i, int j) {
        if(i<0 ||i>m || j<0 ||j>n || marix[i][j]!=1){
            return;
        }
        marix[i][j] = 2;
        infect(marix,m,n,i-1,j);
        infect(marix,m,n,i+1,j);
        infect(marix,m,n,i,j-1);
        infect(marix,m,n,i,j+1);
    }

}
