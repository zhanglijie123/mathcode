package improve.动态规划.cp;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/28 0028 1:18
 */
public class XHs {

    public static void main(String[] args) {
        //101答案
        int[] arr = new int[]{1, 2, 100, 4};
        int i = winGet(arr);
        System.out.println(i);
        int i2 = winGet2(arr);
        System.out.println(i2);

    }

    private static int winGet2(int[] arr) {
        int[][] f = new int[arr.length ][arr.length];
        int[][] s = new int[arr.length][arr.length ];
        for(int i=0;i<arr.length;i++){
            s[i][i] = 0;
            f[i][i] = arr[i];
        }
        int col = 1;
        int row = 0;
        while(col<arr.length){
            int i = row;
            int j = col;//对角线延申
            while(i<arr.length && j<arr.length) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j -1]);
                i++;
                j++;
            }
            col++;
        }

        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);

    }

    private static int winGet(int[] arr) {
        return Math.max(f(arr,0, arr.length-1),s(arr,0,arr.length-1));
    }

    private static int s(int[] arr, int l, int r) {
        if(l==r){
            return 0;
        }
        return Math.min(f(arr,l+1,r),f(arr,l,r-1));
    }

    private static int f(int[] arr, int l, int r) {
        if(l==r){
            return arr[l];
        }
        return Math.max(arr[l]+s(arr,l+1,r),arr[r]+s(arr,l,r-1));
    }

}
