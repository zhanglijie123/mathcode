package MiddleTwo.贪心;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/31 0031 13:11
 */
public class HappenOneNums {
    public static int solution1(int num) {
        if (num < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i != num + 1; i++) {
            count += get1Nums(i);
        }
        return count;
    }

    public static int get1Nums(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                res++;
            }
            num /= 10;
        }
        return res;
    }

    /**
     *  最高位是1 的(N代表此阶段最大值）
     *     N%(10^k-1) +1
     *   +(k-1)*10(k-2)
     *
     *  最高位不是1的（T代表此阶段最大值最高位的数字）
     *    10^k-1
     *   + (k-1)*T*10^k-2
     * @param num
     * @return
     */
    public static int solution2(int num) {
        if (num < 1) {
            return 0;
        }
        int len = getLenOfNum(num);
        if (len == 1) {
            return 1;
        }
        //245454->100000
        int tmp1 = powerBaseOf10(len - 1);
        int first = num / tmp1;
        int firstOneNum = first == 1 ? num % tmp1 + 1 : tmp1;
        int otherOneNum = first * (len - 1) * (tmp1 / 10);
        return firstOneNum + otherOneNum + solution2(num % tmp1);
    }

    public static int getLenOfNum(int num) {
       int len = 0;
       while(num!=0){
           len++;
           num = num/10;
       }
       return len;
    }

    public static int powerBaseOf10(int base) {
        return (int) Math.pow(10, base);
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        return solution2(n);
    }

    public static void main(String[] args) {
        int i = solution2(13);
        System.out.println(i);
    }
}
