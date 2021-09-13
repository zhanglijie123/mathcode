package base.yihuo;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/3 0003 1:44
 *
 */
public class FindOdd {
    public static void main(String[] args) {
        int[] ones = {1, 1, 414, 1,1};
        //如果一个数组其中只有一个数出现了奇数次，其他数都出现了偶数次，找到这个出现奇数次的这个数
        int result = findOddOne(ones);
        System.out.println(result);
        //如果两个数组其中只有一个数出现了奇数次找到这个数其他数都出现了偶数次，找到这两个出现奇数次的数
        int[] twos = {3, 9, 41, 21,41,21};
        findOddTwoNums(twos);
    }

    private static void findOddTwoNums(int[] twos) {
        int eor =0;
        int eor1 = 0;
        for (int temp:twos){
            eor ^= temp;
        }
        int rightOne = eor &(~eor +1);
        for(int t:twos){
            if((rightOne & t) == rightOne){
              eor1 ^=t;
            }
        }
        System.out.println(eor1);
        System.out.println(eor1^eor);
    }

    private static int findOddOne(int[] ones) {
        int result = 0;
        for (int one : ones) {
            result = one^result;
        }
        return  result;
    }

    }

