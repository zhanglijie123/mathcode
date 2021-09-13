package MiddleOne.classSix;

import java.util.TreeMap;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/29 0029 21:16
 * 给你一个字符串类型的数组arr，譬如： String[] arr = { "b\\cst", "d\\", "a\\d\\e", "a\\b\\c" };
 * 你把这些路径中蕴含的目录结构给画出来，子目录直接列在父目录下面，并比父目录 向右进两格，
 * 就像这样:
 *      a
 *         b
 *            c
 *        d
 *            e
 *      b
 *        cst
 *      d
 * 同一级的需要按字母顺序排列，不能乱。
 * 这个题就是用到前缀树的原型
 */
public class FolderStruct {
    public static void main(String[] args) {
        String[] arr= { "b\\cst", "d\\", "a\\d\\e", "a\\b\\c" };
        print(arr);

    }

    private static void print(String[] arr) {
        Node head = generatePrefixTree(arr);
        printProcess(head,0);
    }

    private static void printProcess(Node head, int level) {
        if(level!=0){
            System.out.println(getSpace(level)+head.name);
        }
        for(Node cur:head.nextMap.values()) {
                printProcess(cur,level+1);
        }


    }

    private static String getSpace(int level) {
        String res ="";
        for(int i=1;i<level;i++){
            res+="  ";
        }
        return res;
    }

    private static Node generatePrefixTree(String[] arr) {
        Node root = new Node("");
        for (String s : arr) {
            String[] split = s.split("\\\\");
            Node cur = root;
            for (String s1 : split) {
                if(!cur.nextMap.containsKey(s1)){
                    cur.nextMap.put(s1,new Node(s1));
                }
                cur = cur.nextMap.get(s1);
            }
        }
        return root;
    }

    public static class Node{
        public String name;
        public TreeMap<String,Node> nextMap;
        public Node(String name){
            this.name = name;
            nextMap = new TreeMap<>();
        }
    }
}
