manacher的四个概念：
1 回文半径和直径
2 辅助数组
3 回文的中心点
4 临时右边界

O(n)
求解的是最长回文子串
比如 abc1234321aba  的最长回文子串是1234321即7而不是aba(3)  求解过程中必须加上#串起来比如abaad需要#a#b#a#a#d#

暴力方式的就是每个遍历，在遍历同时左右延申判断是否回文并记录返回最长的，那么时间复杂度就是O(n^2)

1）中心点没有在r区域内一般第一次的时候 r=-1  cur=0 center = 0;   R--------cur------.......

以0为中心左右暴力扩 =》r=0 半径=1


2）中心点在r区域内
 2.1 cur`在LR内部并且cur`回文字符在LR内部   --L—————（————cur`————）———center--------cur---------R--
      cur的回文半径和cur`的一样

 2.2 cur`回文左边跑出去了     -(--L----cur`----L`-)---------center-------------cur----R---
     cur的回文区是cur-R区

 2.3 cur`压中L            --(L------cur`------)certer-------cur-------R--
     cur的回文区至少大于等于cur`

 伪代码：
  public static int[] manacher(String s ){
   //1221->#1#2#2#1#
   s->处理带上#的str
   int[] pAddr = new int[str.length];
   str = str.toCharArr();
   for(int i=0;i<str.length;i++){
     if(i在R外部）{
       从i位置往两边暴力括
     }else{
       if(i`回文区在LR里面){
         pAddr[i] = pAddr[i`];
       }else if(i`回文区有一部分在外部也就是超过左边界){
         pAddr[i] = R-i;
       }else{ //i`压中L边界
         pAddr[i] >=pAddr[i`],所以pAddr[i]其实就从R+1开始校验

       }
     }
   }
  }

  从伪代码上看一个for循环 时间复杂度O(n)



  https://mp.weixin.qq.com/s?__biz=Mzg4ODMwNzY0MA==&mid=2247484289&idx=1&sn=5e8e8db61eefa9253706907a261c784d&chksm=cffc6956f88be040da92395db3287c97a508ee9994f85e4866fb1e12ddb37f73216dbb7423fb&token=2139155983&lang=zh_CN#rd

