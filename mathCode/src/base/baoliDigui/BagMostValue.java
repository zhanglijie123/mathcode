package base.baoliDigui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/26 0026 15:17
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物 品不能超过这个重量。返回你能装下最多的价值是多少？
 */
public class BagMostValue {

    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process1(weights, values, 0, 0,0, bag);
    }

    private static int process1(int[] weights, int[] values, int i, int alreadyWeight, int alreadyValues, int bag) {
        if(alreadyWeight>bag){
            return 0;
        }
        if(i==values.length){
            return  alreadyValues;
        }
        return  Math.max(
            process1(weights,values,i+1,alreadyWeight,alreadyValues,bag),
            process1(weights,values,i+1,alreadyWeight+weights[i],alreadyValues+values[i],bag)
        );
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(weights, values, bag));
    }
}
