eatgrass+getminbagstobuapples是关于打表法的技巧
而染色和是预处理数组的技巧


  private static String getWinner(int i) {
       if(i<5){
           return i==0||i==2?"后手":"先手";
       }
       int base =1;//
       while(base<=i){//
           if(getWinner(i-base).equals("后手")){//
               return "先手";
           }
           if(base*4>i){//
               break;
           }
           base = base*4;//
       }
       return "后手";
    }
    
    
    
    苹果的rest 和apples不要使用一个变量
    随机改下位移操作必须加上括号
