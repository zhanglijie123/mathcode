模型一：从左往右尝试
1.从左往右 要和不要的模型  字符串子序列组合要和不要 满足某种情况最少方法数（满足货币要求有多少中尝试方法） 
     { base.baoliDigui.PrintSubSeq   base.baoliDigui.BagMostValue  improve.动态规划.CoinWaysOnlyTry  improve.动态规划.ConisRandomZhangs }
1.2. 从左往右 有效和无效+要和不要模型  。达到要求时候货币最小数量 {improve.动态规划.LessCoins}
 private static int process(int[] arr, int i, int rest) {
         if(rest<0){
             return -1;
         }
         if(rest==0){
             return 0;
         }
         if(i==arr.length){
             return -1;
         }
         int p1 = process(arr,i+1,rest);
         int p2 = process(arr,i+1,rest-arr[i]);
         if(p1==-1 && p2==-1){
             return -1;
         }else {
             if (p1 == -1) {
                 return 1 + p2;
             }
             if (p2 == -1) {
                 return p1;
             }
             return Math.min(p1, p2+1);
         }
     }
1.3.1 从左往右 在正在尝试位置做某种决策的尝试（之前的尝试已经定了），比如交换 求子符排列组合 当遍历到i位置时候 关注i和其他位置交换尝试  { base.baoliDigui.GenerateAllPailie }
1.3.2 从左往右 在正在尝试的位置做某种决策尝试（之前的尝试已经定了），比如尝试此位置和后面的位置是否组合满足要求   {base.baoliDigui.StringToLetter}
模型二：从某个位置出发为了满足要求往左右两边尝试 机器人问题 { improve.动态规划.MachineMan }

模型三： 范围上尝试 先后手问题玩扑克  { base.baoliDigui.GetPuke }
   比如：1 .
   
   
   
   
   ====================================================
           process(chars,i+1);  不調整的执行
           char aChar = chars[i];   
           chars[i] = 0;  去了
           process(chars,i+1);  调整的操作
           chars[i] = aChar;  加回来
   ================================================        
                   process(toCharArray,i+1,res,result); //不调整的执行
                   List<Character> you = cp(res); 
                   Character temp = toCharArray[i];//必须上转非基本类型便于下面的res.remove(temp)是同一个对象
                   res.add(temp);  加了
                   process(toCharArray,i+1,res,result);  调整的执行
                   res.remove(temp); 去了
 
    ====================================================
     *********如果先调整的要自己开辟空间否则影响后面的******
                 //pick
                 ArrayList<Integer> temp =  cp(integers);
                 temp.add(nums[i]);
                 process1(nums,res,i+1,temp);//如果要就要自己开辟补干扰下面的
                 //no pick
                 process1(nums,res,i+1,integers);
   ======================================================
        System.out.println(String.valueOf(res).length()+String.valueOf(res));
           List<Character> result = new ArrayList<>();
           for (Character re : res) {//for循环过滤掉假长度 比如[a]实际有三个，表面看一个  但是通过for过滤掉
               result.add(re);
           }