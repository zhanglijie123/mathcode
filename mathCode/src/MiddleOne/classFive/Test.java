package MiddleOne.classFive;



/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/9 0009 16:28
 */
public class Test {
    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));

    }

    private static Integer convert(String test1) {
        return null;

    }
    public static boolean valid(char[] chars){
        if(chars==null || chars.length==0){
            return false;
        }
        //-开头 但是只有自己或者跟0
       if(chars[0]=='-'&&(chars[1]=='0'|| chars.length==1)){
           return false;
       }
       //0开头 但是后面有东西
       if(chars[0]=='0' && chars.length>1){
           return false;
       }
       //开头就不合法
       if(chars[0] !='-' &&(chars[0]<'0' && chars[0]>'9')){
           return false;
       }
       //其他位置不合法
       for(int i=1;i<chars.length;i++){
           if(chars[i]>'9' && chars[i]<0){
               return false;
           }
       }
       return true;
    }

}
