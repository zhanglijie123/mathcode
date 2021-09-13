package base.tree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/11 0011 9:45
 * 折纸问题
 *       凹           1
 *   凹      凸       2
 * 凹  凸   凹  凸     3
 *
 * true:凹
 * false:凸
 * 将上面的中序遍历下就是折纸的从上往下的折痕轨迹
 */
public class Zhezhi {

    public static void main(String[] args) {
        int level = 2;
        printZhezhi1(level);
    }

    private static void printZhezhi1(int level) {
        proces1(0,level,true);
    }

    private static void proces1(int i, int level, boolean b) {
        if(i>level){
            return;
        }
        proces1(i+1,level,true);
        System.out.print(b?"凹":"凸");
        proces1(i+1,level,false);
    }

    private static void printZhezhi(int level) {

            process(1,level,true);//true代表位凹 ，false代表凸，第一层默认凹开始从折纸发现的

    }

    private static void process(int i, int level, boolean b) {
        if(i > level){
            return;
        }
        process(i+1,level,true);
        System.out.print(b?"凹":"凸");
        process(i+1,level,false);
    }

}
