package MiddleOne.classFive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/5 0005 15:15
 */
public class JoBHard {
    public static void main(String[] args) {
        Job job = new Job(1, 2);
        Job job1 = new Job(5, 2);
        Job job2 = new Job(2, 12);
        Job job3 = new Job(4, 13);
        Job[] jobs = new Job[]{job,job1,job2,job3};
        int[] ablities = new int[]{2,3,4,5,6};
        int[] res = getMoreMoney(jobs,ablities);
        for (int re : res) {
            System.out.println(re);//12 12 13 13 13
        }
    }

    private static int[] getMoreMoney(Job[] jobs, int[] ablities) {
        Arrays.sort(jobs,new MoreMoneyComparator());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(jobs[0].hard,jobs[0].money);
        //遍历已经工作难度由小达到 获得报酬由大到小的jobs，然后利用treeMap让工作难度越大 报酬越多，也就是过滤掉可能工作难度大报酬反而小的情况
        Job pre = jobs[0];
        for(int i=0;i<jobs.length;i++){
            if(jobs[i].hard!=pre.hard && jobs[i].money>pre.money){
                pre = jobs[i];
                treeMap.put(pre.hard,pre.money);
            }
        }
        int[] res = new int[ablities.length];
        for(int j=0;j<ablities.length;j++){
            Integer key = treeMap.floorKey(ablities[j]);
            if(key!=null){
                res[j] = treeMap.get(key);
            }
        }
        return res;

    }
    public static class MoreMoneyComparator implements Comparator<Job>{

        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard==o2.hard?o2.money-o1.money:o1.hard-o2.hard;//工作难度由小达到，相同工作难度的报酬由大到小
        }
    }
    public static class Job{
        public int hard;
        public int money;

        public Job(int hard, int money) {
            this.hard = hard;
            this.money = money;
        }
    }
}
