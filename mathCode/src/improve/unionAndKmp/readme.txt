union O(1)
kmp O(n)

kmp研究的是：
字符串str1和str2，str1是否包含str2，如果包含返回str2在str1中开始的位置。 如何做到时间复杂度O(N)完成？
因为如果用暴力方式解决就是O(Str1.len*Str2.len)而是用Kmp可以加速成O（n)级别



kmp是将str2转出next数组，这个数组是指比如next[i],next[i]=0~i-1上最大的前后缀匹配的长度多少（舍去（0-（i-1））的整体
然后我们通过next数组去加速
