package MiddleOne.classOne;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/3 0003 14:13
 * 小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个 每袋的包装包装不可拆分。可是小虎现在只想购买恰好n个苹果，
 * 小虎想购买尽 量少的袋数方便携带。如果不能购买恰好n个苹果，小虎将不会购买。输入一个 整数n，表示小虎想购买的个苹果，
 * 返回最小使用多少袋子。如果无论如何都不 能正好装下，返回-1。
 */
public class GetMinBagsToBuApples {
    public static void main(String[] args) {
        for(int i=0;i<101;i++){
            int res =  getMinBagsOne(i,8,6);
            System.out.println(i+"-- "+res);
            int res2 =  getMinBagsTwo(i );
            System.out.println(i+"-- "+res2);
            if(res!=res2){
                System.out.println(i);
                break;
            }
        }
    }

    /**
     * 总结规律的方式
     *
     * @param apples
     * @param
     * @param
     * @return
     */
    private static int getMinBagsTwo(int apples) {
        if((apples&1)==1 || apples<6 ||apples==10 ){
            return -1;
        }
        if(apples==6 || apples==8){
            return 1;
        }
        if(apples==12||apples==14 || apples==16){
            return 2;
        }


      return (apples-18)/8+3;
    }

    /**
     * 一般方式
     *
     * @param apples
     * @param eight
     * @param six
     * @return
     */
    private static int getMinBagsOne(int apples, int eight, int six) {
      if(apples==0 || apples<six || apples%2!=0){
          return -1;
      }
      int minGb = (eight*six)/getMaxGy(eight,six);
      int eightBags = apples/eight;
      int rest  =apples-(eightBags*eight);
      int sixBags=-1;
      while(rest>=0 && rest<minGb && eightBags>=0){
          int minSix = minBagBase6(rest);
          if(minSix!=-1){
              sixBags = minSix;
              break;
          }
          rest = apples-(--eightBags*eight);
      }
      return sixBags==-1?-1:sixBags+eightBags;

    }


    public static int minBagBase6(int rest) {
       return rest%6==0?(rest/6):-1;
    }

    /**
     * 求最大公约数--即最大公因子
     *
     * @param a
     * @param b
     * @return
     */
   public static int getMaxGy(int a, int b){
       return b==0?a:getMaxGy(b,a%b);
   }

    /**
     * 最小公倍数 =两数乘积/最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static int minGb(int m, int n) {
        return (m * n) / getMaxGy(m, n);
    }

}
