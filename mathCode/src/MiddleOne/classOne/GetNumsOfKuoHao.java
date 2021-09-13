package MiddleOne.classOne;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/15 0015 1:44
 * 一个完整的括号字符串定义规则如下: ①空字符串是完整的。 ②如果s是完整的字符串，那么(s)也是完整的。 ③如果s和t是完整的字符串
 * ，将它们连接起来形成的st也是完整的。
 * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")" 是不完整的括号字符串。
 * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化 为一个完整的括号字符串。
 * 请问牛牛至少需要添加多少个括号。
 */
public class GetNumsOfKuoHao {
    public static void main(String[] args) {
        int sum = getNumsOfKH("())(");
        int sum1 = getNumsOfKH1("())(");
        System.out.println(sum);
        System.out.println(sum1);
    }

    /**
     * 这种方式是无效的因为会遇到类使的情况 ())(
     * 除非题目要求 ())(这种是合法的 这种方式才成立
     * @param s
     * @return
     */
    private static int getNumsOfKH1(String s) {
        int count =0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar=='('){
                count++;
            }else{
                count--;
            }
        }
        return Math.abs(count);
    }

    private static int getNumsOfKH(String s) {
        int count =0;//代表左括号比右括号多几个 即需要加几个右括号
        int answer =0;//代表需要加多少个左括号
        char[] strs = s.toCharArray();
        for(int i=0;i<strs.length;i++){
            if(strs[i]=='('){
                count++;
            }else{
                if(count==0){
                    answer++;
                }else {
                    count--;
                }
            }
        }
        return answer+Math.abs(count);
    }
}
