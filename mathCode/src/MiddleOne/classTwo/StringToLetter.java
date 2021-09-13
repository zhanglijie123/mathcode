package MiddleOne.classTwo;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/16 0016 15:22
 */
public class StringToLetter {
    public static void main(String[] args) {
        int sum = transferToLetterNums("12258");
        System.out.println(sum);
    }

    private static int transferToLetterNums(String s) {
        if(s==null || s.length()==0 ){
            return 0;
        }
        return process(s.toCharArray(),0);//从左往右的尝试
    }

    private static int process(char[] strs, int i) {
        if(i==strs.length){
            return 1;
        }
        if(strs[i]=='0'){
            return 0;
        }
        if(strs[i]=='1'){
            int res = process(strs,i+1);
            if(i+1<strs.length){
                res+=process(strs,i+2);
            }
            return res;
        }
        if(strs[i]=='2'){
            int res = process(strs,i+1);
            if(i+1<strs.length && strs[i]<='6' &&strs[i]>='0'){
                res+=process(strs,i+2);
            }
            return res;
        }
        //其他情况3·9
        return process(strs,i+1);

    }
}
