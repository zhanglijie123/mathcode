package 面试;


import java.util.Stack;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/15 0015 15:23
 *
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 */
public class Main{
    public static void main(String[] args ){

        int[] arr = new int[]{10,5,2,6};
        int target = 100;
         processFor(arr,target);
      //  processStack(arr,target);
    }

    private static void processStack(int[] arr, int target) {

        Stack<Integer> stack = new Stack<>();
        int sum = 1;
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                sum *= arr[j];
                if (sum > target) {
                    System.out.println(stack);
                    sum =1;
                    stack.clear();

                } else {
                    System.out.println(arr[j]);
                  //  stack.push(arr[j]);
                }
            }
        }
    }

    public static void  processFor(int[] arr,int target){
        int now=1;
        int j=0;
        int n=arr.length;
        for(int i=0;i<n;i++){ //判读以i结尾的区间 从哪些位置开始乘积小于target
            now*=arr[i]; //加上当前的数
            while(j<=i&&now>=target){j++;now/=target;}
            // 对于j到i-1符合要求 那么判断j到i是否符合要求 如果不符合就要往后移动
            //此处的复杂度为O(n) 不能再降低

            //找到当前j到i的乘积小于target 那么j到i j+1到i j+2到i ... i到i均符合要求
            //以下将所有情况输出
            for(int k=j;k<=i;k++){ //从j到i开始，到i结束的区间均满足情况
                for(int m=k;m<=i;m++){ //输出从k开始 ，i结束的区间
                    System.out.print(arr[m]);
                    System.out.print(' ');
                }
                System.out.println();
            }//
        }
    }
}
