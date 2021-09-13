package base.baoliDigui;

/**
 * @author zhanglijie
 * @version 1.0bi
 * @since 1.1.0 2021/2/26 0026 14:20
 * 数字组成的字符 串 转成字母
 * 比如 1 A   11  AA
 * 数字1- 26对应 A -Z
 *   如111 可以变成AAA  KA  AK
 *   那么给定一个数字字符串求可以得到哪些字母字符
 */
public class  StringToLetter {



    public static void main(String[] args) {
        System.out.println(number("12258"));
    }

    private static int number(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        return process(str.toCharArray(),0);
      // return process1(str.toCharArray(),0);
    }


    private static int process(char[] chars, int i) {
        if(i==chars.length){
            return 1;//说明之前的合格
        }
        if(chars[i]=='0'){
            return 0;
        }
        if(chars[i]=='1'){
            int res = process(chars,i+1);//i单独作为一个部分，那么后续从i+1开始
            if((i+1)<chars.length){
                res+=process(chars,i+2);//i和i+1作为一个整体部分，后续从i+2开始
            }
            return res;
        }
        if(chars[i]=='2'){
            int res = process(chars,i+1);//间i单独为一部分，后续从i+1开始
            if((i+1)<chars.length && chars[i+1]>='0' && chars[i+1]<='6'){
                res+= process(chars,i+2);//将i和i+1作为单独一部分，后续从i+2开始
            }
            return res;
        }
        //chars[i] 3~9区间，只能单独作为一部分处理
        return process(chars,i+1);
    }
}
