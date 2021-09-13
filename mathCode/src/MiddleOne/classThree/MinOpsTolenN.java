package MiddleOne.classThree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/3 0003 17:12
 * 假设s和m初始化，s = "a"; m = s; 再定义两种操作，
 * 第一种操作： m = s; s = s + s;
 * 第二种操作： s = s + m;
 * 求最小的操作步骤数，可以将s拼接到长度等于n
 *
 * 思路：如果s的长度是质数直接调用操作2是最小的操作数，（第一次方式一方式二效果相同，如果想拼接成质数长度直接一直调用操作二即可）
 *      如果s的长度是非质数比如12.我们可以将12拆成质数的乘积  12 = 2*3*2 、、
 *            当然2，3，2顺序中只有一种排列组合最优，可以使用12 =a*b*c构成。由于质数a需要调操作2 a-1次，质数b需要调b-1次  质数c需要c-1次。总共需要a+b+c-3
 *
 *      总结质素长度 return n-1
 *      非质数n ,n=a*b*c*f...  retrun a+b+c+f+...-质数因子个数
 */
public class MinOpsTolenN {
    public static void main(String[] args) {
        System.out.println(minOps(42));

    }
    // 附加题：怎么判断一个数是不是质数？
    public static boolean isPrim(int n) {
        if (n < 2) {
            return false;
        }
        int max = (int) Math.sqrt((double) n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {//质数是因子只有1 和本身 ，如果因子》=2不再是本身就不是质数
                return false;
            }
        }
        return true;
    }

    // 请保证n不是质数
    // 返回:
    // 0) 所有因子的和，但是因子不包括1
    // 1) 所有因子的个数，但是因子不包括1
    public static int[] divsSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[] { sum, count };
    }

    public static int minOps(int n) {
        if (n < 2) {
            return 0;
        }
        if (isPrime2(n)) {
            return n - 1;
        }
        int[] divSumAndCount = divEleAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }

    public static boolean isPrime2(int n){
        if(n<2){
            return false;
        }
        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i<=sqrt;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int[] divEleAndCount(int n){
        int count = 0;
        int sum = 0;
        for(int i=2;i<=n;i++){
            while(n%i==0){
                count++;
                sum +=i;
                n /=i;
            }
        }
        return new int[]{sum,count};
    }
}
