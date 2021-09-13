package exerciseOne.Seq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/5 0005 2:18
 * 电话号码的组合
 */
public class TeleNoCom {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxtz");
        LinkedList<String> res = new LinkedList<>();
        search("", 0, res, digits, map);
        return res;

    }

    private void search(String s, int i, LinkedList<String> res, String digits, HashMap<Character, String> map) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String temp = map.get(digits.charAt(i));
        for (int k = 0; k < temp.length(); k++) {
            search(s + temp.charAt(i), i + 1, res, digits, map);
        }

    }
}
