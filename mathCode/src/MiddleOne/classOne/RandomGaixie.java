package MiddleOne.classOne;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/4/14 0014 0:51
 * 给定一个函数f，可以1～5的数字等概率返回一个。
 * 请加工出1～7的数字等概率 返回一个的函数g。 给定一个函数f，
 * 可以a～b的数字等概率返回一个。请加工出c～d的数字等概率 返回一个的函数g。 比如13~21  然后加工成30~59
 * 给定一个函数f，以p概率返回0，以1-p概率返回1。请加工出等概率返回0和1的 函数g
 */
public class RandomGaixie {
    //可以转变成random(0,29)+30
    public static int rand30To59(){
        int res;
        do{
            res=(rand1Or0()<<5)+(rand1Or0()<<4)+(rand1Or0()<<3)+ (rand1Or0()<<2)+(rand1Or0()<<1)+rand1Or0();
        }while(res>29);
        return res+30;

    }
    public static int random0Ot1Two(){
        int res;
        do{
            res = rand13To21();
        }while(res==21);
        return res<17?0:1;
    }
    //可以转变位random(0~8)+13
    public static int rand13To21(){
        int res;
        do{
            res=(rand1Or0()<<3)+ (rand1Or0()<<2)+(rand1Or0()<<1)+rand1Or0();
        }while(res>8);
        return res+13;
    }
    public static int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
           // System.out.println(random0Ot1Two());
           // System.out.println(rand1Or0());
        // System.out.println(rand1To7());
         //   System.out.println(rand13To21());
            System.out.println(rand30To59());
        }
    }
    public static int rand1Or0(){
        int res;
        do{
            res = rand1To5();
        }while (res==5);
        return res<3?0:1;
    }

    /**
     * random(1-7)可以变成random(0-6)+1
     * @return
     */
    public static int rand1To7(){
       int res;
       do{
           res = (rand1Or0()<<2)+(rand1Or0()<<1)+rand1Or0();
       }while (res==7);
       return res+1;
    }

    /**
     * 以p 概率返回0
     * @return
     * 以1-p概率返回1
     */
    public static int pAndNp(){return 0;}

    /**
     * 扔两次 nAndP
     * 结果分别 r1 r2
     * 如果  0 0 或者 1 1就是 pp (1-p)^2
     * 所以当 1 0 或者 0 1时候的概率就是 p*(1-p)等概率
     * @return
     */
    public static int g(){
        int r1;
        int r2;
        do{
            r1 = pAndNp();
            r2 = pAndNp();
        }while(r1==r2);
        return r1==0?0:1;
    }
}
