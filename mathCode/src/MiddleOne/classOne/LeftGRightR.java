package MiddleOne.classOne;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/14 0014 22:24
 * 实现左侧为G右侧为R的最小染色体数量
 */
public class LeftGRightR {
    public static void main(String[] args) {
        String test = "RRRRRRGGGGGRRGRRGRRRRGGR";
        System.out.println(minPaint(test));
        System.out.println(minPaint2(test));
    }

    private static int minPaint2(String test) {
        int min = Integer.MAX_VALUE;
       int N = test.length();
       int[] G = new int[N];
       int[] R = new int[N];
        char[] chars = test.toCharArray();

        //左侧有多少个R可以从头开始算
        if(chars[0]=='R'){
            R[0] =1;
        }
        for(int i=1;i<N;i++){

            if(chars[i]=='R'){
                R[i] = R[i-1]+1;
            }else{
                R[i] = R[i-1];
            }
        }
        //右侧有多少个G可以倒着算
        if(chars[N-1] == 'G'){
            G[N-1] = 1;
        }
        for(int i=N-2;i>=0;i--){
            if(chars[i] =='G'){
              G[i] = G[i+1]+1;
            }else{
                G[i] = G[i+1];
            }
        }

       for(int i=0;i<=N;i++){
           if(i==0){
               //将R染成G
               min = Math.min(min,G[0]);
           }else if(i==N){
               //将G染成R
               min = Math.min(min,R[N-1]);

           }else {
               //普遍 将左侧的R染成G  右侧的G染成R
               min = Math.min(min, R[i-1] + G[i]);
           }
       }
       return min;
    }

    //以GGGGGR作为测试用例
    private static int minPaint(String str) {
        int min = Integer.MAX_VALUE;
        char[] strs = str.toCharArray();
        char indexC = strs[0];
        int N = strs.length;
        //辅助数组，统计从0~N-1r的个数
        int[] r = new int[N];
        if(indexC=='R'){
            r[0] = 1;
        }
        for(int i=1;i<N;i++){
           if(strs[i]=='R'){
               r[i] =r[i-1]+1;
           }else{
               r[i] = r[i-1];
           }
        }
        //辅助数组，从0~n-1G的个数
        int [] g = new int[N];
        char tailC = strs[N-1];
        if(tailC=='G'){
            g[N-1] = 1;
        }
        for(int i=N-2;i>=0;i--){
            if(strs[i]=='G'){
                g[i] =g[i+1]+1;
            }else{
                g[i] = g[i+1];
            }
        }
        for(int i=0;i<=N;i++){
            if(i==0){//统计从0开始0左边为G右侧为R 意思就是所有变成R  统计数组有多少个G染成R
            min= Math.min(min,g[i]);
            }else if(i==N){//统计从0~N-1全部为G的需要染色多少个R  GGGGGG
            min = Math.min(min,r[i-1]);
            }else{//其他情况 ：左边将R染成G +右侧将G染成R
            min = Math.min(r[i-1]+g[i],min);
            }
        }
        return min;

    }
}
