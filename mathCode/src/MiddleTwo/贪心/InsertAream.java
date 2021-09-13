package MiddleTwo.贪心;

import java.util.ArrayList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/6 0006 14:47
 * 插入区间
 *
 * 给定一组不重叠的时间区间，在时间区间中插入一个新的时间区间(如果有重叠的话就合并区间)。
 * 这些时间区间初始是根据它们的开始时间排序的。
 * 示例1:
 * 给定时间区间[1,3]，[6,9]，在这两个时间区间中插入时间区间[2,5]，并将它与原有的时间区间合并，变成[1,5],[6,9].
 * 示例2：
 * 给定时间区间[1,2],[3,5],[6,7],[8,10],[12,16],在这些时间区间中插入时间区间[4,9]，并将它与原有的时间区间合并，变成[1,2],[3,10],[12,16].
 * 这是因为时间区间[4,9]覆盖了时间区间[3,5],[6,7],[8,10].
 */
public class InsertAream {

       public static class Interval {
           int start;
           int end;
           Interval() {
               start = 0;
               end = 0;
           }
           Interval(int s, int e) {
               start = s;
               end = e;
           }
       }

    public static void main(String[] args) {
        InsertAream o = new InsertAream();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,5));
        list.add(new Interval(6,7));
        list.add(new Interval(8,10));
        list.add(new Interval(12,16));

        Interval aim = new Interval(4,9);
        ArrayList<Interval> insert = o.insert(list, aim);
        for (Interval interval : insert) {
            System.out.println(interval.start +" " +interval.end);
        }

    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int i = 0;
        // 左侧不会被影响到的区间，原封不动放入结果序列中
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }

        // i 结尾了;要么，items.get(i).end >= newItems.start
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}
