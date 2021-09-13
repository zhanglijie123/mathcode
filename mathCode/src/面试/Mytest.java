package 面试;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.MaskFormatter;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/17 0017 21:11
 *
 评测题目:  给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 示例 1:
  输入: "abcabcbb" abcabcdd a3 b4 c5 d6 slow3 fast6
  输出: 3 +
  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3.

  示例 2:
  输入: "bbbbb"
  输出: 1
  解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。b1 b2 b3 b4

  示例 3:
  输入: "pwwkew"  p0 w5 slow2
  输出: 3
  解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
       请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */
public class Mytest {
    public static void main(String[] args) {
        String str = "pwwkew";
        int max = lengthOfLongestSubstring(str);
        System.out.println(max);

    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while(right < n){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, set.size());
            right++;
        }
        return ans;
    }

    private static int getMaxLength(String str) {
        char[] chars = str.toCharArray();
        int N = chars.length;
        int slow = 0;
        int fast = 1;
        int max = 0;
        int count = 1;
        while(slow<N && fast<N){
            if(chars[slow]!=chars[fast]){
                fast++;
                count++;
             //   max = Math.max(max,count);
            }else{
                max = Math.max(max,count);
                count =1;
                slow++;
                fast=slow+1;
            }
        }
        return max;
    }
/*
    public static int getMaxLen(String str){
        char[] chars = str.toCharArray();
        int N = chars.length;
        int[] dp = new int[N];

    }*/


}
