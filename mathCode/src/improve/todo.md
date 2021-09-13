第一课的布隆
第五课的大数据
最后一课有序表的avl左右调整旋转

注意单调栈的比较 比较时候使用 arr[stack.peek().get(0)]或者 arr[stack.peek().get(stack.peek().size()-1)]  取出的时候使用size()-1
   滑动窗口使用下标以及两个if
   
   
   背的：
    private static int winGet2(int[] arr) {
           int[][] f = new int[arr.length ][arr.length];
           int[][] s = new int[arr.length][arr.length ];
           for(int i=0;i<arr.length;i++){
               s[i][i] = 0;
               f[i][i] = arr[i];
           }
           int col = 1;
           int row = 0;
           while(col<arr.length){
               int i = row;
               int j = col;//对角线延申
               while(i<arr.length && j<arr.length) {
                   f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                   s[i][j] = Math.min(f[i + 1][j], f[i][j -1]);
                   i++;
                   j++;
               }
               col++;
           }
   
           return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
   
       }
       
       
       private static void delsRes(int[] part, ArrayList<List<String>> lists) {
              String str = "";
               ArrayList<String> strings = new ArrayList<>();
               for(int i=0;i<part.length;i++){
                   int index = part[i];
                   for(int j=0;j<part.length;j++){
                       if(j==index){
                           str+="Q";
                       }else{
                           str+=".";
                       }
       
                   }
       
                   strings.add(str);
                   str="";
               }
              lists.add(strings);
       
           }


 
 
动态规划重新来 shouhou 机器人 lessCoins   mirros huanlink