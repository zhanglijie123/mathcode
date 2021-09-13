package base.digui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/4 0004 1:22
 */

/**
 * 使用递归完成求数组最大值
 */
public class GetMax {
    public static void main(String[] args) {
        int[] ints = {1, 212, 41, 232};
        int max = getMaxOfArray(ints,0,ints.length-1);
        int max1 = getMaxOfArray(ints,0,ints.length-1);
        System.out.println(max==max1);
    }

    private static int getMaxOfArray(int[] ints, int l, int r) {
      if(l==r){
          return ints[l];
      }
      int mid = l+((r-l)>>1);
        int left = getMaxOfArray(ints, l, mid);
        int right = getMaxOfArray(ints, mid+1, r);
        return Math.max(left,right);

    }

    private static int getMaxOfArray2(int[] ints, int l, int r) {
      if(l==r){
          return ints[l];//
      }
      int mid = l+((r-l)>>1);
      int left = getMaxOfArray2(ints,l,mid);
      int right = getMaxOfArray2(ints,mid+1,r);
      return Math.max(ints[left],ints[right]);

    }
}
