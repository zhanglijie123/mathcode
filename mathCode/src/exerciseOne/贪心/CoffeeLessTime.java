package exerciseOne.贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/5 0005 16:06
 */
public class CoffeeLessTime {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 7};//三台咖啡机制作咖啡的时间分别是3，2，7
        int N = 10;//10个人
        int a = 3;//洗咖啡杯的时间
        int b = 4;//自然挥发的时间
        int time = getMinTime(arr,N,a,b);
        //   int time3 = getMinTime3(arr,N,a,b);
        System.out.println(time);
    }

    private static int getMinTime(int[] arr, int n, int a, int b) {
        PriorityQueue<Node> p = new PriorityQueue<>(new NodeCoffeeComparator());
        for (int i : arr) {
            Node node = new Node(0, i);
            p.add(node);
        }
        int[] he = new int[n];
        for(int i=0;i<n;i++){

            Node poll = p.poll();
            poll.start+=poll.end;
            he[i] = poll.start;//当前人喝完咖啡的时间点
            p.add(poll);//重新放到小根堆钟

        }
        if(a>b){
            return he[he.length-1]+b;
        }
        return process(he,0,a,b,0);

    }

    private static int process(int[] he, int i, int a, int b, int washLine) {
        if(i==he.length-1){
            return Math.min(Math.max(he[i],washLine)+a,he[i]+b);
        }
        int wash = Math.max(he[i],washLine)+a;//此处用机器洗杯子
        int next = process(he,i+1,a,b, wash);//继续往后尝试
        int p1 = Math.max(wash,next);
        int huifa = he[i]+b;
        int next2 = process(he,i+1,a,b,washLine);
        int p2 = Math.max(huifa,next2);
        return Math.min(p1,p2);


    }


    public static class NodeCoffeeComparator implements Comparator<Node> {


        @Override
        public int compare(Node o1, Node o2) {
            return  (o1.start+o1.end)-(o2.start+o2.end);
        }
    }
    public static class Node{
        public int start;
        public int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
