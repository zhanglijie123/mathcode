package MiddleOne.classFour;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/7 0007 14:17
 * 如果一个字符串为str，把字符串str前面任意的部分挪到后面形成的字符串叫
 * 作str的旋转词。比如str="12345"，str的旋转词有"12345"、"23451"、
 * "34512"、"45123"和"51234"。给定两个字符串a和b，请判断a和b是否互为旋转
 * 词。
 * 比如：
 * a="cdab"，b="abcd"，返回true。
 * a="1ab2"，b="ab12"，返回false。
 * a="2ab1"，b="ab12"，返回true。
 *
 * 思路：a=a+a  a.contain(b)?
 *
 */
public class RotateWord {
    public static void main(String[] args) {
        String a = "1ab2";
        String b = "ab12";
        boolean isRotate = isRotateWord(a,b);
        System.out.println(isRotate);
    }

    private static boolean isRotateWord(String a, String b) {
        String str1 = a+a;
        String str2 = b;
        int i = indexOfByKmp(str1, str2);
        return i==-1?false:true;
    }
    public static int indexOfByKmp(String str1,String str2){
        if(str1==null ||str1.length()<1 ||str2==null ||str1.length()<str2.length()){
            return -1;
        }
        int i1 =0 ;
        int i2 = 0;
        int[] next = getNext(str1.toCharArray());
        char[] chars = str1.toCharArray();
        char[] chars1 = str2.toCharArray();
        while(i1<chars.length && i2<chars1.length){
            if(chars[i1] == chars1[i2]){
                i1++;
                i2++;
            }else if(next[i2]!=-1){
                i2 = next[i2];
            }else{
                i1++;
            }
        }
        return i2 ==str2.length()?i1-i2:-1;
    }

    /**
     * 这个数组是指比如next[i],next[i]=0~i-1上最大的前后缀匹配的长度多少（舍去（0-（i-1））的整体
     * @param chars
     * @return
     */
    private static int[] getNext(char[] chars) {
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i=2;
        while(i<chars.length){
            if(chars[i-1]==chars[cn]){
                next[i++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
