package base.前缀树;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/23 0023 20:23
 * 前缀树的操作
 */
public class TireTree {
    public static void main(String[] args) {
        Tire trie = new Tire();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixSearch("zui"));
    }

   public static class Tire{
       private  TireNode root;
       public Tire(){
           root = new TireNode();
       }
       public  void insert(String str){
           if(str ==null){
               return;
           }
           char[] chars = str.toCharArray();
           TireNode node = root;
           node.pass++;
           int index=0;
           for(char c : chars){
              index = c-'a';
              if(node.nexts[index]==null){
                  node.nexts[index ] = new TireNode();
              }
              node = node.nexts[index];
              node.pass++;
           }
           node.end++;

       }
       public void delete(String str){
           //如果有才删否则不操作
           if(search(str)>0 && str!=null){
               char[] chars = str.toCharArray();
               int index = 0;
               TireNode node = root;
               node.pass--;
               for(char c : chars){
                   index = c-'a';
                   if(--node.nexts[index].pass == 0){
                       node.nexts[index] = null;//都已经为null了那么末尾的end原来也就一个end,为null后也就不存在了即end=0  str直插入了一次
                       return;
                   }
                   node = node.nexts[index];
               }
               node.end--;//这个表示str肯定不止插入一次 或者还有别的元素的前缀是str 才会走到这里

           }
       }
       //查询插入了几次str字符
       public int search(String str){
          if(str==null){
              return 0;
          }
          char[] chars = str.toCharArray();
          int index  =0;
          TireNode node = root;
          for(char c:chars){
              index = c-'a';
              if(node.nexts[index] ==null){
                  return 0; //如果中间就断了表示 不完整也就是chars还没遍历完
              }
              node = node.nexts[index];
          }
          return node.end;
       }
       //查询存在str为前缀的有几个
       public int prefixSearch(String str){
           if(str==null){
               return 0;
           }
           char[] chars = str.toCharArray();
           int index  =0;
           TireNode node = root;
           for(char c:chars){
               index = c-'a';
               //如果字符串有存在全部字符串都要匹配的就不会null，,如果字符串不在前缀树上则会null即使字符串部分在树上 return0好了
               if(node.nexts[index] ==null){
                   return 0;
               }
               node = node.nexts[index];
           }
           return node.pass;
       }


   }









    public static class TireNode{
        private int pass;
        private int end;
        public TireNode[] nexts;

        public TireNode() {
            this.pass = 0;
            this.end = 0;
            nexts = new TireNode[26];
        }
    }

}
