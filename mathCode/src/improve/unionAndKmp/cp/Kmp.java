package improve.unionAndKmp.cp;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/24 0024 19:37
 */
public class Kmp {
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        int index = getFirstIndexSubStr(str,match);//不是子串就返回-1
        System.out.println(index);
    }

    private static int getFirstIndexSubStr(String str, String aim) {
        if(str==null || aim==null ||(  (str!=null && aim!=null)&& (str.length()<aim.length()))){
            return -1;
        }

        char[] str1 = str.toCharArray();
        char[] str2 = aim.toCharArray();
        int[] next = getNextArr(str2);
        int i1 = 0;
        int i2 = 0;
        while(i1<str1.length && i2<str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2]==-1){
                i1++;
            }else{

                i2 = next[i2];
            }
        }
        return i2==str2.length?i1-i2:-1;


    }

    private static int[] getNextArr(char[] chars ) {
        int[] next = new int[chars.length];
        next[0] =-1;
        next[1] = 0;
        int i =2;
        int cn =0;
        while(i<chars.length){
            if(chars[i-1] == chars[cn]){
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
