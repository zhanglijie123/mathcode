package exerciseOne.前缀树;

import javax.swing.tree.TreeNode;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/8 0008 15:31
 */
public class PrefixTreeTest {
    PreTree root = new PreTree();
    public static class PreTree{
        public int pass;
        public int end;
        public PreTree[] next;

        public PreTree() {
            this.pass = 0;
            this.end = 0;
            this.next = new PreTree[26];
        }
    }

    public static void main(String[] args){
        PrefixTreeTest op = new PrefixTreeTest();
        op.insert("abc");
        op.insert("abc");
        op.insert("abc");
        System.out.println(op.insertNum("abc"));
        op.delete("abc");
        System.out.println(op.insertNum("abc"));
        System.out.println(op.prefixNum("ab"));
    }

    private int prefixNum(String abc) {
        if(abc==null || abc.length()==0){
            return 0;
        }
        PreTree cur = root;
        for (char c : abc.toCharArray()) {
            int index = c-'a';
            if(cur.next[index]==null){
                return 0;
            }
            cur = cur.next[index];

        }
        return cur.pass;
    }

    private void delete(String abc) {
        if(insertNum(abc)!=0){
            PreTree cur = root;
            cur.pass--;
            for (char c : abc.toCharArray()) {
                int index= c-'a';
                if(--cur.next[index].pass==0){
                    cur.next[index] = null;
                    return;
                }
                cur = cur.next[index];
                cur.pass--;
            }
            cur.end--;
        }
    }

    private int insertNum(String abc) {
        if(abc==null || abc.length()==0){
            return 0;
        }
        PreTree cur = root;
        for (char c : abc.toCharArray()) {
            int index = c-'a';
            if(cur.next[index]==null){
                return 0;
            }
            cur = cur.next[index];

        }
        return cur.end;
    }

    private void insert(String abc) {
        if(abc==null || abc.length()==0){
            return;
        }

        PreTree cur  = root;
        cur.pass++;
        for (char c : abc.toCharArray()) {
           int index =  c- 'a';
           if(cur.next[index]==null){
               cur.next[index] = new PreTree();
           }
           cur = cur.next[index];
           cur.pass++;
        }
        cur.end++;
    }
}
