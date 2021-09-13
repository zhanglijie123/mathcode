package MiddleOne.classFour;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 17:21
 * 京东算法第四题：
 * 给定一个int类型的数组比如[3,2,7]这个数组代表有三台咖啡机，制作咖啡的时间分别是3，2，7分钟。
 * 然后给定一个整数N表示N个人需要喝咖啡，这N个人每个人都必须喝到一杯咖啡，喝咖啡的时间不计。
 * 假设有台洗咖啡杯的机器，它洗碗一个杯子需要的时间是a.如果不洗自然挥发的时间是b,挥发的效果和洗的效果一样挥发完之后也是可以用的。
 * 求这套流程走完（咖啡机泡咖啡让N个人喝完后并且咖啡杯被干净化）需要的最少安排的时间值
 *
 *
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/  这个是序列化反序列哈临时加的题目
 */
public class CoffeLessTime {
    public static class Machine{
        public int start;
        public int costTime;

        public Machine(int start, int costTime) {
            this.start = start;
            this.costTime = costTime;
        }
    }
    public static class MachineComparator implements Comparator<Machine>{

        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.start+o1.costTime)-(o2.start+o2.costTime);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 7};//三台咖啡机制作咖啡的时间分别是3，2，7
        int N = 10;//10个人
        int a = 3;//洗咖啡杯的时间
        int b = 4;//自然挥发的时间
        int time = getMinTime(arr,N,a,b);
        int time2 = getMinTime2(arr,N,a,b);
     //   int time3 = getMinTime3(arr,N,a,b);
        System.out.println(time);
        System.out.println(time2);
       // System.out.println(time3);

    }

    /**
     * 动态规划版本
     * @param arr
     * @param n
     * @param a
     * @param b
     * @return
     */
    private static int getMinTime3(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> queue = new PriorityQueue<>(new MachineComparator());
        for (int i : arr) {
            queue.add(new Machine(0,i));
        }
        int [] drinks = new int[n];
        for(int i=0;i<n;i++){
            Machine poll = queue.poll();
            poll.start+=poll.costTime;
            drinks[i] = poll.start;//当前人喝完咖啡的时间点
            queue.add(poll);//重新放到小根堆钟
        }
        if(a>=b){
            return drinks[n-1]+b;
        }
        int[][] dp = new int[n][drinks[n-1]+n*a];
        for(int i=0;i<dp[0].length;i++){
            dp[n-1][i] = Math.min(Math.max(i,drinks[i-1])+a,drinks[i-1]+b);
        }
        for(int row=n-2;row>=0;row--){
            int washLine = drinks[row]+(row+1)*a;
            for(int col=0;col<washLine;col++){
                int wash = Math.max(col,drinks[row]+a);
             //   dp[row][col] = Math.min(Math.max(wash,dp[row+1][wash]),Math.max(drinks[row-1]));
            }
        }
        return dp[0][0];
    }

    /**
     * 记忆搜索表法 比一般递归节约时间复杂度
     * @param arr
     * @param n
     * @param a
     * @param b
     * @return
     */
    private static int getMinTime2(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> queue = new PriorityQueue<>(new MachineComparator());
        for (int i : arr) {
            queue.add(new Machine(0,i));
        }
        int [] drinks = new int[n];
        for(int i=0;i<n;i++){
            Machine poll = queue.poll();
            poll.start+=poll.costTime;
            drinks[i] = poll.start;//当前人喝完咖啡的时间点
            queue.add(poll);//重新放到小根堆钟
        }
        int[][] dp = new int[n][drinks[n-1]+n*a];
        for(int i=0;i<n;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] =-1;
            }
        }
        return process1(drinks,a,b,0,0,dp);
    }

    private static int process1(int[] drinks, int a, int b, int index, int washLine, int[][] dp) {
        if(dp[index][washLine]!=-1) {
            return dp[index][washLine];
        }
        if(index==drinks.length-1){//最后一个杯子
            dp[index][washLine] =   Math.min(drinks[index]+b,Math.max(drinks[index],washLine)+a);
            return dp[index][washLine];
        }
        //使用洗咖啡杯的机器完成
        int wash = Math.max(drinks[index],washLine)+a;
        int next = process(drinks,a,b,index+1,wash);
        int p1 = Math.max(wash,next);

        //自然挥发情况
        int fresh = drinks[index]+b;
        int nextF = process(drinks,a,b,index+1,washLine);
        int p2 = Math.max(fresh,nextF);

        //返回两种情况最小
        dp[index][washLine] =  Math.min(p1,p2);
        return dp[index][washLine];
    }

    /**
     * 一般递归完成 耗时
     * @param arr
     * @param n
     * @param a
     * @param b
     * @return
     */
    private static int getMinTime(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> queue = new PriorityQueue<>(new MachineComparator());
        for (int i : arr) {
            queue.add(new Machine(0,i));
        }
        int [] drinks = new int[n];
        for(int i=0;i<n;i++){
            Machine poll = queue.poll();
            poll.start+=poll.costTime;
            drinks[i] = poll.start;//当前人喝完咖啡的时间点
            queue.add(poll);//重新放到小根堆钟
        }
        return process(drinks,a,b,0,0);
    }

    /**
     *
     * @param drinks  表示喝完咖啡的时间点集合--咖啡杯可以被洗的开始时间点
     * @param a    洗咖啡杯的时间
     * @param b    自然挥发的时间
     * @param index   正在遍历的下标
     * @param washLine  洗咖啡杯机器什么时间点开始空余
     * @return  喝完咖啡后并且咖啡杯也被洗完或挥发完的最后时间点--最少值
     */
    private static int process(int[] drinks, int a, int b, int index, int washLine) {
        if(index==drinks.length-1){//最后一个杯子
            return  Math.min(drinks[index]+b,Math.max(drinks[index],washLine)+a);
        }
        //使用洗咖啡杯的机器完成
        int wash = Math.max(drinks[index],washLine)+a;
        int next = process(drinks,a,b,index+1,wash);
        int p1 = Math.max(wash,next);

        //自然挥发情况
        int fresh = drinks[index]+b;
        int nextF = process(drinks,a,b,index+1,washLine);
        int p2 = Math.max(fresh,nextF);

        //返回两种情况最小
        return Math.min(p1,p2);
    }
}
