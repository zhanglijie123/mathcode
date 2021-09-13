package improve.动态规划;

import java.util.List;

import base.map.base.Node;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/24 0024 22:48
 */
public class Test {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        Test test = new Test();
        String s = test.longestCommonPrefix(strs);
        System.out.println(s);

    }
    public String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return null;
        }
        Prefix  prefixNode = new Prefix ();
        //前缀树
        for (String str : strs) {
            prefixNode.insert(str);
        }
        int N = strs.length;
        int max = 0;
        String maxStr = null;
        for(int i=0;i<N;i++){
            String str = strs[i];
            if(str.length()>=max){
                max = str.length();
                maxStr = str;
            }
        }
        max = 0;
        for (int i=1;i<=maxStr.length();i++){
           int x =  prefixNode.preFixSearch(maxStr.substring(0,i));
           if(x==N){
               max++;
           }
        }
       return maxStr.substring(0,max);

    }
    public class Prefix{
        PrefixNode root = new PrefixNode();
        public void insert(String s){
            if(s==null){
                return;
            }
            char[] chars = s.toCharArray();
            PrefixNode node =root;
            node.pass++;
            for (char aChar : chars) {
                int index = aChar-'a';
                if(node.next[index] == null){
                    node.next[index] = new PrefixNode();
                }
                node = node.next[index];
                node.pass++;
            }
            node.end++;
        }
        public int preFixSearch(String s){
            if(s==null){
                return 0;
            }
            PrefixNode node =root;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                int index= aChar-'a';
                if(node.next[index] == null){
                    return 0;
                }
                node =node.next[index];
            }
            return node.pass;
        }
    }
    public class PrefixNode{
        public PrefixNode[] next;
        public int pass;
        public int end;
        public PrefixNode( ) {
            this.pass = 0;
            this.end = 0;
            this.next = new PrefixNode[26];
        }
    }

    public String longestCommonPrefix1(String[] strs) {
        //todo
        if(strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if(ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

}
