package improve.manacher.cp;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/24 0024 0:08
 * 求最大回文子串长度
 * abc1234321aba
 *   结果：  7
 */
public class MaxHWSubLen {
    public static void main(String[] args) {
      //  String str = "abccbadsfaetfwa";
        String str = "abc1234321ab";
        int maxLen = getMaxLenByManacher(str);
        System.out.println(maxLen);

    }

    private static int getMaxLenByManacher(String str) {
        if(str == null || str.length()==0){
            return 0;
        }
        char[] strs = getDelStr(str);
        int R = -1;
        int C= -1;
        int[] pAddr = new int[strs.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<strs.length;i++){
            //至少区域
            pAddr[i] = R > i ? Math.min(pAddr[2 * C - i], R - i) : 1;
         //  pAddr[i] = i>=R?1:Math.min(pAddr[2*C-i],R-i);
            //下面左右括看看是否区域能延申
            while((pAddr[i]+i)<strs.length && (i-pAddr[i])>=0){
                if(strs[(pAddr[i]+i)] == strs[(i-pAddr[i])]){
                    pAddr[i] ++;
                }else{
                    break;
                }
            }
            if(pAddr[i]+i>R){
                C = i ;
                R = pAddr[i]+i;
            }
            max = Math.max(pAddr[i],max);
        }
        return max-1;
    }

    private static char[] getDelStr(String str) {
        char[] chars = str.toCharArray();
        int N = str.length();

        char[] res = new char[2 * N + 1];
        int j = 0;

        for(int i=0;i<res.length;i++){
           res[i] = (i&1)==0?'#':chars[j++];
        }
        return res;
    }
}
