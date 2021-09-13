package MiddleOne.classTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/16 0016 0:21
 *
 * 给一个包含n个整数元素的集合a，一个包含m个整数元素的集合b。
 * 定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，且操作过 后每个集合的平均值都大大于于操作前。
 *              0）放入后每个集合的平均值都大大于于操作前。
 * 注意以下两点： 1）不可以把一个集合的元素取空，这样就没有平均值了
 *              2）值为x的元素从集合b取出放入集合a，但集合a中已经有值为x的元素，
 *              则a的 平均值不变（因为集合元素不会重复），b的平均值可能会改变（因为x被取出 了）问最多可以进行多少次magic操作？
 *
 *         分析：
 *          1  集合平均值相同：集合a  它的平均值为100   集合b  它的平均值也为100  不管从a拿值放到b还是从b拿值放到a他们都会违反0）
 *          2  集合平均值不同：集合a 它的平均值为100   集合b 它的平均值为50 那么我们可以从集合a中拿50~100到集合b，两个集合的平均值都会相同
 *             而且我们如果在集合a中从小到大拿 拿的机会会更多
 */
public class Magic {
    // 请保证arr1无重复值、arr2中无重复值，且arr1和arr2肯定有数字
    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += (double) arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += (double) arr2[i];
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int i = 0; i < arrMore.length; i++) {
            double cur = (double) arrMore[i];
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize)
                && !setLess.contains(arrMore[i])) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int size) {
        return sum / (double) (size);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 5 };
        int[] arr2 = { 2, 3, 4, 5, 6 };
        System.out.println(maxOps(arr1, arr2));

    }

}
