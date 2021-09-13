package base.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/23 0023 22:05
 * 安排会议，求最佳安排情况能最多安排几个会议
 */
public class BestArrayMeeting {

    public static void main(String[] args) {

        Meeting m1 = new Meeting(1, 2);//开始1点结束2点
        Meeting m2 = new Meeting(2, 6);
        Meeting m3 = new Meeting(3, 6);
        Meeting m4 = new Meeting(7, 8);
        Meeting m5 = new Meeting(7, 11);

        Meeting[] meetings = {m1,m2,m3,m4,m5};
        //标杆起始时间是0点后有效

        System.out.println( bestArrange(meetings, 0) ==  bestArrange1(meetings, 0));
    }

    private static int bestArrange1(Meeting[] meetings, int start) {
        Arrays.sort(meetings, new MeetingEndComparator ());
        int sum =0;
        int cur = 0;
        for (Meeting meeting : meetings) {
            if(meeting.start>=cur){
                sum++;
                cur = meeting.end;
            }
        }
        return sum;
    }

    public static int bestArrange(Meeting[] programs, int start) {
        Arrays.sort(programs,new MeetingEndComparator());
        int res = 0;
        for (Meeting program : programs) {
            if(start<= program.start){
                res++;
                start = program.end;
            }
        }
        return res;
    }
    public static class Meeting{
        //会议开始时间
        public int start;
        //会议结束时间
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class MeetingEndComparator implements Comparator<Meeting>{

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end-o2.end;
        }
    }
}
