package MiddleOne.classSix;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/29 0029 21:43
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 * 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示,
 * 不需要 照亮的障碍物格子用'X'表示。小Q现在要在道路上设置一些路灯,
 * 对于安置在 pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 * 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需 要多少盏路灯
 *
 *
 */
public class MinLightsNum {
    //str是只包含两种类型的字符一个是'.' 另一个是‘X’
    //一个路灯可以照亮左中右三个位置
    //要求把‘.'这种位置全部照亮才行
    //返回最小路灯数量
    public static int getMinLights(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int n = chars.length;
        int res = 0;
        int index =0;
        while(index<n){
            if(chars[index]=='X'){
                index++;
            }else {
                res++;
                if ((index + 1) == n) {
                    break;
                } else {
                    if (chars[index + 1] == 'X') {
                        index += 2;
                    } else   {
                        index += 3;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String test = "....X...X.X..XX.XX.X.X.X.X.XX.XXX.X.XXX.XX";

        System.out.println(getMinLights(test));
    }


}
