package improve.动态规划;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/29 0029 22:35
 * 先手后手抓扑克
 */
public class XianHouShou {


    public static void main(String[] args) {
        //101答案
        int[] arr = new int[]{1, 2, 100, 4};
        int i = winGet(arr);
        System.out.println(i);
        int i2 = winGet2(arr);
        System.out.println(i2);

    }

    private static int winGet2(int[] arr) {
        if(arr==null ||arr.length==0 ){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            f[i][i]=arr[i];
        }
        int row = 0;
        int col = 1;
        while(col<arr.length){
            int i = row;
            int j = col;
            while(i<arr.length && j<arr.length){
                //对角线延申
                f[i][j] = Math.max(arr[i]+s[i+1][j],arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
                i++;
                j++;
            }
            //第二个对角线
            col++;
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
    }

    private static int winGet(int[] arr) {
        if(arr==null || arr.length==0){
            return 0;
        }
        //决策下
        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }

    private static int f(int[] arr, int l, int r) {
        if(l==r){
            return arr[l];
        }
        return Math.max( arr[l]+s(arr,l+1,r),arr[r]+s(arr,l,r-1));
    }

    private static int s(int[] arr, int l, int r) {
        if(l==r){
            return 0;
        }
        return Math.min(f(arr,l+1,r),f(arr,l,r-1));
    }
}




