package improve.bigData;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/27 0027 23:16
 * 判断一个32位的正数是否是2或者4的次幂
 */
public class IsTwoOrFourCimi {
    public static void main(String[] args) {
        int two = 4;
        int four = 16;

        System.out.println(isTwoCimi(two));
        System.out.println(isFourCimi(four));
    }

    private static boolean isFourCimi(int four) {
        return isTwoCimi(four) && (four & 0x55555555)!=0;
    }

    /**
     * 查看二进制中是否只有一个位上是1 其他位是0  .。那么我们可以让这个数减1,这样他就打散，比如 2^3-1 = 0111
     * return (2^3)&(2^3-1)==0
     * @param two
     * @return
     */
    private static boolean isTwoCimi(int two) {
        return (two&(two-1))==0;
    }
}
