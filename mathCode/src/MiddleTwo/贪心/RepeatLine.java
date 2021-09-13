package MiddleTwo.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/31 0031 0:31
 * 每一个线段都有start和end两个数据项，表示这条线段在X轴上从start位置开始到end位置结束。
 * 给定一批线段，求所有重合区域中最多重合了几个线段，首尾相接的线段不算重合。
 * 例如：线段[1,2]和线段[2.3]不重合。
 * 线段[1,3]和线段[2,3]重合
 *3
 * 1 2
 * 2 3
 * 1 3
 *
 * 输入描述:
 * 第一行一个数N，表示有N条线段
 * 接下来N行每行2个数，表示线段起始和终止位置
 *
 *
 * 输出描述:
 * 输出一个数，表示同一个位置最多重合多少条线段
 */
public class RepeatLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] start = new int[N];
        int[] end = new int[N];
        for(int i=0;i<N;i++){
            start[i] = scanner.nextInt();
            end[i] = scanner.nextInt();
        }

       int cpLine =  getRepeatLine(start,end);
        //int cpLine2 =  getRepeatLine2(start,end);//错误方式
       // int cpLine3 =  getRepeatLine3(start,end);
        System.out.println(cpLine);
      //  System.out.println(cpLine3);

    }

   /* private static int getRepeatLine3(int[] start, int[] end) {
        if(start==null || end ==null || start.length!=end.length){
            return 0;
        }
        TreeSet<Line> startTreeSet = new TreeSet<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.start - o2.start;
            }
        });
        TreeSet<Line> endTreeSet = new TreeSet<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.end - o2.end;
            }
        });
        for(int i=0;i<start.length;i++){
            if(start[i]!=end[i]){//线段起始位置和末尾位置不能重复
                startTreeSet.add(new Line(start[i],end[i]));
            }
        }
        int max = 0;
        System.out.println(startTreeSet.size()+"set");
        while(!startTreeSet.isEmpty()){
            Line line = startTreeSet.pollFirst();
            while(!endTreeSet.isEmpty() && endTreeSet.first().end<=line.start){
                endTreeSet.pollFirst();
            }
            endTreeSet.add(line);
            max = Math.max(max,endTreeSet.size());
        }
        return max;
    }

    *//**
     * 此方法错误的根源没有对start排序，但是只对start排序了就打乱了end和start的对应关系，所以还是需要两个有序表，泛型必须是结合start 和 end的结合体完成
     * 这样既完成start排序也将start和end对应上
     * @param start
     * @param end
     * @return
     *//*
    private static int getRepeatLine2(int[] start, int[] end) {
        if(start==null || end ==null ||start.length!=end.length) {
            return 0;
        }

       TreeSet< Integer> treeSet = new TreeSet<>( );
        int max = 0;
        for(int i=0;i<start.length;i++){

            while(!treeSet.isEmpty() && treeSet.first() <=start[i]){
                treeSet.pollFirst();
            }
            treeSet.add(start[i]);
            max = Math.max(max,treeSet.size());
        }

        return max;
    }*/

    private static int getRepeatLine(int[] start, int[] end) {
        if (start == null || end == null || start.length != end.length) {
            return 0;
        }
        PriorityQueue<Line> startPriorityQueue = new PriorityQueue<>(new StartValueComparator());
        for(int i = 0;i<start.length;i++){
            if(start[i] != end[i]){
                startPriorityQueue.add(new Line(start[i],end[i]));
            }
        }
        System.out.println(startPriorityQueue.size()+"sdfsadf");
        int max = 0;
        PriorityQueue<Line> endPriorityQueue = new PriorityQueue<Line>(new EndValueComparator());
       while(!startPriorityQueue.isEmpty()){
           Line poll = startPriorityQueue.poll();
           while(!endPriorityQueue.isEmpty() && endPriorityQueue.peek().end<=poll.start){
             endPriorityQueue.poll();
           }
           endPriorityQueue.add(poll);
           max = Math.max(max,endPriorityQueue.size());
       }
       return max;

    }
    public static class StartValueComparator implements Comparator<Line>{

        @Override
        public int compare(Line o1, Line o2) {
            return o1.start-o2.start;
        }
    }
    public static class EndValueComparator implements Comparator<Line>{

        @Override
        public int compare(Line o1, Line o2) {
            return o1.end-o2.end;
        }
    }
    public static class Line{
        private int start;
        private int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
