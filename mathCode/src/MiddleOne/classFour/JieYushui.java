package MiddleOne.classFour;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/6 0006 21:19
 * 接雨水 返回最大值
 * 给定一个数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器， 请返回容器能装多少水
 * 比如，arr = {3，1，2，5，2，4}，
 * 根据值画出的直方图就是容器形状，该容 器可以装下5格水
 * 再比如，arr = {4，5，1，3，2}，该容器可以装下2格水
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class JieYushui {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,1,2,5,2,4};//5
        int[] arr2 = new int[]{4,5,1,3,2};//2
        int[] arr3 = new int[]{4,2,0,3,2,5};//9
        System.out.println(getWater1(arr2 )==getWater4(arr2));
        System.out.println(getWater1(arr1)==getWater4(arr1));
        System.out.println(getWater1(arr3 )==getWater4(arr3));

    }
   //recode getWater3
    public static int getWater1(int[] arr){
        int N = arr.length-2;
        int[] rightMax= new int[N];
        rightMax[N-1] = arr[N+1];
        for(int i=N-2;i>=0;i--){
            rightMax[i] =  Math.max(rightMax[i+1],arr[i+2]);
        }
        int leftMax = arr[0];
        int value = 0;
        for(int i=1;i<=N;i++){
            value+=Math.max(0,Math.min(leftMax,rightMax[i-1])-arr[i]);
            leftMax =Math.max(leftMax,arr[i]);
        }
        return value;

    }
    //recocde getWater4
    public static int getWater2(int[] arr){
        int leftMax = arr[0];
        int rightMax = arr[arr.length-1];
        int l = 1;
        int r = arr.length-2;
        int value = 0;
        while(l<=r){
            if(leftMax<=rightMax){
                value += Math.max(0,Math.min(leftMax,rightMax)-arr[l]);
                leftMax = Math.max(leftMax,arr[l++]);

            }else{
                value += Math.max(0,Math.min(leftMax,rightMax)-arr[r]);
                rightMax = Math.max(rightMax,arr[r--]);
            }
        }
        return value;
    }
    public static int getWater3(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int n = arr.length - 2;
        int[] rightMaxs = new int[n];
        //辅助数组
        rightMaxs[n - 1] = arr[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
        }
        int leftMax = arr[0];
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMax, rightMaxs[i - 1]) - arr[i]);
            leftMax = Math.max(leftMax, arr[i]);
        }
        return value;
    }

    public static int getWater4(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int value = 0;
        int left = arr[0];
        int right = arr[arr.length-1];
        int l=0;
        int r = arr.length-1;
        while(l<=r){
            if(left<right) {
                value += Math.max(0, left - arr[l]);
                left = Math.max(arr[l++], left);
            }else{
                value += Math.max(0, right - arr[r]);
                right = Math.max(arr[r--], right);
            }
        }
        return value;

    }
}
