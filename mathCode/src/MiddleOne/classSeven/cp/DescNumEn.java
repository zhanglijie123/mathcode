package MiddleOne.classSeven.cp;

import java.util.Map;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/8 0008 12:42
 */
public class DescNumEn {
    public static void main(String[] args) {

    }
    public static String oneTo19(int num){
      if(num<1 || num>19){
          return "";
      }
      String[] names = { "One ", "Two ", "Three ", "Four ", "Five ", "Six ",
          "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ",
          "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Sixteen ",
          "Eighteen ", "Nineteen " };
        return names[num - 1];
    }
    public static String oneTo99(int num){
        if(num<1 || num>99){
            return "";
        }
        String[] names = { "Twenty ", "Thirty ", "Forty ", "Fifty ",
            "Sixty ", "Seventy ", "Eighty ", "Ninety " };
        int n = num/10;
        return names[n-2]+oneTo19(num%10);
    }
    public static String oneTo999(int num){
        if(num<1 || num>999){
            return "";
        }
        return oneTo19((num/100))+"hundred"+oneTo99(num%100);
    }
    public static String descNumEnExp(int num){
        if(num ==0){
            return "Zero";
        }
        String str = num<0?"Negative, ":"";
        if(num ==Integer.MIN_VALUE){
            str+="Two Billion,";
            num%=-2000000000;
        }
        num = Math.abs(num);
        int highIndex=0;
        String[] names = {"Billion","Million","Thousand",""};
        int high = 1000000000;
        while (num != 0) {
            int cur = num / high;
            num %= high;
            if (cur != 0) {
                str += oneTo999(cur);
                str += names[highIndex] + (num == 0 ? " " : ", ");
            }
            high /= 1000;
            highIndex++;
        }
        return str;

    }
}
