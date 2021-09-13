package exerciseOne.kuohao;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/1 0001 10:19
 * * 一个完整的括号字符串定义规则如下: ①空字符串是完整的。 ②如果s是完整的字符串，那么(s)也是完整的。 ③如果s和t是完整的字符串
 * * ，将它们连接起来形成的st也是完整的。
 * * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")" 是不完整的括号字符串。
 * * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化 为一个完整的括号字符串。
 * * 请问牛牛至少需要添加多少个括号。
 */
public class GetNumsKuoHao {
    public static void main(String[] args) {
        int sum = getNumsOfKH(")())(((");
        System.out.println(sum);

    }

    private static int getNumsOfKH(String s) {
        int count = 0;
        int answer = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                if (count == 0) {
                    answer++;
                } else {
                    count--;
                }
            }
        }
        return Math.abs(count) + Math.abs(answer);
    }
}
