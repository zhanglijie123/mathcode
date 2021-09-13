package improve.manacher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/29 0029 12:05
 *
 *
 * (
 * //评测题目一:
 * // 有两个List， A 和 B。 A代表的是买入列表（买入份数、单价，时间），B代表的是卖出列表（卖出份数，单价，时间）
 * // 计算：剩余的总份数以及剩余部分的买入总金额。
 * // 买入list :
 * // 第一次： <1000, 1.5, 2021-01-01>
 * // 第二次： <1000, 2.1, 2021-01-05>
 * // 第三次： <1000, 1.7, 2021-01-07>
 * // 第四次： <1000, 1.1, 2021-01-09>
 *
 * // 卖出list :
 * // 第一次： <2500, 2.2, 2021-01-08>
 *
 * // 则结果为：
 * // <1500, 1950>
 *
 *
 * // 要求：先买的会被先卖; 每一次买或卖，所有份数的单价都是相同的
 */
public class Caculate {

    public static void main(String[] args) {
        List<Node> listIn = new ArrayList<>();
        List<Node> listOut = new ArrayList<>();
        Node node1 = new Node(1000, new BigDecimal(1.5), new Date());
        Node node2 = new Node(1000, new BigDecimal(2.1), new Date());
        Node node3 = new Node(1000, new BigDecimal(1.7), new Date());
        Node node4 = new Node(1000, new BigDecimal(1.1), new Date());
        listIn.add(node1);
        listIn.add(node2);
        listIn.add(node3);
        listIn.add(node4);
        Node node5 = new Node(2500, new BigDecimal(2.2), new Date());
        listOut.add(node5);
        List<BigDecimal> res = calate(listIn, listOut);
        System.out.println(res);
    }

    private static List<BigDecimal> calate(List<Node> in, List<Node> out) {
        ArrayList<BigDecimal> res = new ArrayList<>();
        int inP = sumCount(in);
        int outP = sumCount(out);

        BigDecimal inTotalPirce = sumPrice(in);
        BigDecimal firstPar = new BigDecimal(inP - outP);
        if (outP > inP) {
            throw new RuntimeException("不够卖");
        }
        BigDecimal secondParm = getPriceList(in, outP);
        res.add(firstPar);
        BigDecimal subtract = inTotalPirce.subtract(secondParm);
        res.add(subtract);
        return res;

    }

    private static BigDecimal getPriceList(List<Node> in, int count) {
      /* BigDecimal sum = BigDecimal.ZERO;
        for (Node node : in) {

           Node cur = node;
            BigDecimal p =  cur.price;
            for(int i=0;i<cur.sum;i++){
                if(count==0){
                    break;
                }
                count--;
                sum = sum.add(p );
            }
        }
        return sum;*/
       BigDecimal sum = BigDecimal.ZERO;
        for (Node node : in) {
            if(count>=0) {
                //非最后一轮 直接O（1）的multify即可
                if (node.sum < count) {
                    sum = sum.add(node.price.multiply(new BigDecimal(node.sum)));
                    count = count - node.sum;
                } else {
                    //最后一轮才会进这个for统计需要遍历
                    Node cur = node;
                    BigDecimal p = cur.price;
                    for (int i = 0; i < cur.sum; i++) {
                        if (count == 0) {
                            break;
                        }
                        count--;
                        sum = sum.add(p);
                    }
                }
            }
        }
        return sum;
    }

    private static BigDecimal sumPrice(List<Node> list) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Node node : list) {
            sum = sum.add(node.price.multiply(new BigDecimal(node.sum)));
        }
        return sum;
    }

    public static int sumCount(List<Node> list) {
        int sumCount = 0;
        for (Node node : list) {
            sumCount += node.sum;

        }
        return sumCount;
    }

    public static class Node {
        public int sum;
        public BigDecimal price;
        public Date date;

        public Node(int sum, BigDecimal price, Date date) {
            this.sum = sum;
            this.price = price;
            this.date = date;
        }
    }
}
