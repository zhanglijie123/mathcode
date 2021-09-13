package exerciseOne.kuohao;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/1 0001 10:30
 *  * 一个合法的括号匹配序列有以下定义:
 *  * ①空串""是一个合法的括号匹配序列
 *  * ②如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 *  * ③如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 *  * ④每个合法的括号序列都可以由以上规则生成。
 *  * 例如: "","()","()()","((()))"都是合法的括号序列
 *  * 对于一个合法的括号序列我们又有以下定义它的深度:
 *  * ①空串""的深度是0
 *  * ②如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为 max(x,y)
 *  * 3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 *  * 例如: "()()()"的深度是1,"((()))"的深度是3。
 *  * 现在给你一个合法的括号 序列,需要你计算出其深度
 */
public class GetDepthOfKuoHao {
    public static void main(String[] args) {
        String str = "()()()";
        String str2 = "((()))";
        int d =  getDepth(str);
        int d2 =  getDepth(str2);
        System.out.println(d);
        System.out.println(d2);
    }

    private static int getDepth(String str) {
        int count =0;
        int max = 0;
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                count ++;
                max = Math.max(max,Math.abs(count));
            }else{
                count--;
                max = Math.max(max,Math.abs(count));
            }
        }
        return max;
    }
}
