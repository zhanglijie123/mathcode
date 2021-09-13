package base.前缀树;

import com.sun.javafx.sg.prism.NodePath;

import improve.动态规划.Test;
import javafx.beans.property.ObjectProperty;
import jdk.nashorn.internal.ir.CallNode;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/5 0005 13:35
 * 默写前缀树代码
 * 3
 * 2
 * 2
 */
public class  TireTreeNew {
    public static void main(String[] args) {
        OperateTrieNodes op = new OperateTrieNodes();
        op.insert("abc");
        op.insert("abc");
        op.insert("abc");
        System.out.println(op.insertNum("abc"));
        op.delete("abc");
        System.out.println(op.insertNum("abc"));
        System.out.println(op.prefixNum("ab"));

    }

    public static class OperateTrieNodes{
        public PrefixNode root;
        public OperateTrieNodes(){
            root = new PrefixNode();
        }

        public void insert(String str){
            if(str==null || str.length()==0){
                return;
            }
            PrefixNode cur = root;
            cur.pass++;
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                int index = aChar-'a';
                if(cur.next[index]==null){
                    cur.next[index] = new PrefixNode();
                }
                cur = cur.next[index];
                cur.pass++;
            }
            cur.end++;
        }
        public void delete(String str){
           if(str!=null && insertNum(str)>0){
               PrefixNode cur = root;
               cur.pass--;
               char[] chars = str.toCharArray();
               for (char aChar : chars) {
                   int index = aChar-'a';
                   if(--cur.next[index].pass==0){
                       cur.next[index]=null;
                       return;
                   }
                   cur  =cur.next[index];

               }
               cur.end--;
           }
        }
        public int prefixNum(String str){
            if(str==null || str.length()==0){
                return 0;
            }
            PrefixNode cur = root;
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                int index =aChar-'a';
                if(cur.next[index]==null){
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.pass;
        }

        public int insertNum(String str){
            if(str==null || str.length()==0){
                return 0;
            }
            PrefixNode cur = root;
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                int index =aChar-'a';
                if(cur.next[index]==null){
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.end;
        }




    }
    public static class PrefixNode{
        public  PrefixNode[] next;
        public int pass;
        public int end;

        public PrefixNode( ) {
            this.next = new PrefixNode[26];
            this.pass = 0;
            this.end = 0;
        }
    }
}
