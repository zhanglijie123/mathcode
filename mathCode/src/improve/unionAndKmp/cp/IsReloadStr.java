package improve.unionAndKmp.cp;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/24 0024 19:37
 */
public class IsReloadStr {
    public static void main(String[] args) {

        String s = "abcde";
        String ss =  "abced";
        System.out.println(rotateString(s,ss));

    }
    public static boolean rotateString(String s, String goal) {
        String source = s+s;
        int index =  getIndexKmp( source,goal+goal);
        if(index!=-1){
            return true;
        }else{
            return false;
        }

    }

    private static int getIndexKmp(String s, String s1) {
        char[] str1 = s.toCharArray();
        char[] str2 = s1.toCharArray();
        int[] next = getNext(str2);
        int i1 = 0;
        int i2 = 0;
        while(i1<str1.length && i2<str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2];
            }
        }
        return i2==str2.length?i1-i2:-1;
    }

    private static  int[] getNext(char[] str2) {
        int[] next = new int[str2.length];
        next[0] =-1;
        next[1] = 0;
        int i=2;
        int cn = 0;
        while(i<str2.length){
            if(str2[i-1] == str2[cn]){
                next[i++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++] =0;
            }
        }
        return next;
    }
}
