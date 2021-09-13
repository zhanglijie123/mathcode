package improve.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/1 0001 16:06
 * java实现简单的布隆过滤器版本
 */
public class BulongFliter {


        public static  long NUM_SLOTS =1024 * 1024 * 8;// 位图的长度 8M
        public static  int NUM_HASH =8;// hash函数的个数，一个hash函数的结果用于标记一个位
        private BigInteger bitmap = new BigInteger("0");// 位图
/*    static {

        double m = getMAsHashSize(1000000000,0.0001);
        NUM_HASH = (int) getKAsHashFunNums(m,1000000000);

        NUM_SLOTS =  (long)Math.ceil(m);
    }*/

    /**
     *
     * @param n  样本容量
     * @param p  失误率
     * @return   hash数组大小  小数要向上取整数
     * 公式 ： （-n*lnp)/(ln2^2)
     */
        public static double getMAsHashSize(int n,double p){
            return Math.ceil((-n*Math.log(p))/(Math.log(2)*Math.log(2)));
        }

    /**
     * 获得hash函数多少个
     * @param m  hash数组容量大小
     * @param n  样本容量
     * @return  hash函数多少个   结果需要向上取整
     * LN 2 = 0.7 左右
     * 公式： （m/n)*(ln2)
     */
        public static double getKAsHashFunNums(double m,int n){
            return Math.ceil((Math.log(2)*(m/n)));
        }
        public static void main(String[] args) {

            // 测试代码
            BulongFliter bf = new BulongFliter();
            ArrayList<String> contents = new ArrayList<>();
            contents.add("sldkjelsjf");
            contents.add("ggl;ker;gekr");
            contents.add("wieoneomfwe");
            contents.add("sldkjelsvrnlkjf");
            contents.add("ksldkflefwefwefe");

            for (int i = 0; i < contents.size(); i++) {
                bf.addElement(contents.get(i));
            }
            System.out.println(bf.check("sldkjelsvrnlkjf"));   // true
            System.out.println(bf.check("sldkjelnlkjf"));    // false
            System.out.println(bf.check("ggl;ker;gekr"));   // true
        }

        /** 将message+n映射到0~NUM_SLOTS-1之间的一个值 */
        private int hash(String message, int n) {
            message = message + String.valueOf(n);
            try {
               /*  MessageDigest md5 = MessageDigest.getInstance("md5");// 将任意输入映射成128位（16个字节）整数的hash函数
               byte[] bytes = message.getBytes();
                md5.update(bytes);
                byte[] digest = md5.digest();*/
                BigInteger bi = new BigInteger(message);// 至此，获得message+n的md5结果（128位整数）

                return (int) ((int) Math.abs(bi.intValue()) % NUM_SLOTS);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            return -1;
            // return (int)Math.abs(HashFunctions.bernstein(message,NUM_SLOTS));
        }

        /*
         * 处理原始数据 1.hash1(msg)标注一个位…… hash的值域0~NUM_SLOTS-1
         */
        public void addElement(String message) {
            for (int i = 0; i < NUM_HASH; i++) {
                int hashcode = hash(message, i);// 代表了hash1，hash2……hash8
                // 结果，用于标注位图的该位为1
                if (!bitmap.testBit(hashcode)) {// 如果还不为1
                    // 标注位图的该位为1
                    bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
                }
            }

        }

        public boolean check(String message) {
            for (int i = 0; i < NUM_HASH; i++) {
                int hashcode = hash(message, i);
                // hashcode代表一个位置
                if (!this.bitmap.testBit(hashcode)) {
                    // 如果位图的该位为0，那么message一定不存在
                    return false;
                }
            }
            return true;// 不精确，有可能误判
        }
    }

