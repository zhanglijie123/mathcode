package 面试;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/11 0011 18:43
 */
public class Five {
    public Map<String,  Integer > searchKeywordInText(String text,List<String> keywords){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String,  Integer > res = new HashMap<>();
        for (String keyword : keywords) {
            int indexOf = getIndexOfByKmp(text, keyword);

            res.put(keyword,indexOf);
        }
        return res;

    }
    public int getIndexOfByKmp(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return  -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {//如果str2往前推已经到head了，那么通过str2的移动是不能配出匹配的了，就让str1移动
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public   int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];//cn往前跳
            } else {
                next[i++] = 0;//说明实在没有回文字符
            }
        }
        return next;
    }

    //只能通过kmp在规定时间复杂度内完成 首个下标查询 不可以查询下标列表
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String text = "我爱你中国中国";
        String kw1 = "爱你";
        String kw2 = "国";
        list.add(kw1);
        list.add(kw2);
        Five test = new Five();
        Map<String, Integer> rest = test.searchKeywordInText(text, list);
        for (Map.Entry<String, Integer> stringIntegerEntry : rest.entrySet()) {
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }
    }
}
