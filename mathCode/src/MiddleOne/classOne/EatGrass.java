package MiddleOne.classOne;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/5 0005 12:41
 * 牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。 最初有一个装有n份青草的箱子,
 * 牛牛和羊羊依次进行,牛牛先开始。在每个回合中,每个 玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。
 * 不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游 戏,请输出胜利者的名字。
 */
public class EatGrass {
    public static void main(String[] args) {
        for(int i=0;i<=50;i++){
            System.out.println(i+" "+ getWinner(i));
            //  System.out.println(i+" "+ getWinner(i));
            if(getWinner3(i)!=getWinner2(i)&&getWinner2(i)!=getWinner(i) &&getWin(i)!=getWinner(i)){
                System.out.println(i+"不等");
                break;
            }
        }
    }
   public static String getWin(int n){
        if(n<5){
            return n==0||n==2?"后手":"先手";
        }
        int base = 1;
        while(base<=n){
            if(getWin(n-base).equals("后手")){
                return "先手";
            }
            if(base>(n/4)){
                break;
            }
            base *=4;
        }
        return "后手";
   }
    private static String getWinner3(int i) {
        if(i<5){
            return i==0||i==2?"后手":"先手";
        }
        int base =1;
        while(base<=i){
            if(getWinner3(i-base).equals("后手")){
                return "先手";
            }
            if(base>=(i/4)){
               break;
            }
            base *=4;
        }
        return "后手";
    }

    private static String getWinner(int i) {
        //0 1 2 3 4份草情况 0 后手赢 1先手赢 2后手赢 3先手赢 4先手赢
        if(i<5){
            return (i==0 || i==2)?"后手":"先手";
        }
        //i >=5
        int base = 1;//先手开始
        while(base<=i){
            if(getWinner(i-base).equals("后手")){
                return  "先手";
            }
          if(base>(i/4))  {
              break;
          }
          base *=4;
        }
        return "后手";
    }
    private static String getWinner2(int i) {
        if(i%5==0 || i%5==2){
            return "后手";
        }else {
            return "先手";
        }
    }
}
