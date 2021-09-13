package MiddleOne.classTwo;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/15 0015 1:21
 * 给定一个非负整数n，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
 */
public class GetTreeStructsNums {
    public static void main(String[] args) {
        int s =getSumTreeStructs(4);
        int s1 =getSumTreeStructsByDongtaiguihua(4);
        System.out.println(s);
        System.out.println(s1);
    }

    private static int getSumTreeStructs(int n) {
        if(n==0){
            return 1;//空树一个
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        //下面计算左右树普遍现象
        int res = 0;
        for(int l=0;l<=n-1;l++){
            int lefttNums = getSumTreeStructs(l);
            int rightNums = getSumTreeStructs(n-l-1);
            res+= rightNums*lefttNums;
        }
        return res;
    }

    /**
     * 改成动态规划版本
     * @param n
     * @return
     */
    private static int getSumTreeStructsByDongtaiguihua(int n) {
        if(n<2){
            return 1;
        }
        int [] arr = new int[n+1];
        arr[0] =1;
        //填充这个数组,数组下标也就和节点有意义关联了
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i-1;j++){

                arr[i] +=arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
    }
}
