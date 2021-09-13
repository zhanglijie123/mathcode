package improve.hash;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/27 0027 21:22
 */
public class BitMap {
    public static void main(String[] args) {
        int[] arr = new int[10]; //4*8bit*10   = 320 bit
        //高低位  int 意义转出bit
        // arr[0]  int 0~31
        // arr[1]  int 32~63

        int i = 178;//取出178位上bit的信息
        int numIndex = i/32;
        int bitIndex = i%32;

        //178位上bit的状态
        int statuus = ((arr[numIndex] >>bitIndex) &1);

        //把178位上状态改成1
        arr[numIndex] = arr[numIndex] |(1<<bitIndex);
        //把178位上状态改成0
        arr[numIndex] = arr[numIndex] & (~(1<<bitIndex));

    }
}
