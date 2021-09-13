package exerciseOne.前缀树;

import java.util.TreeMap;

import javax.lang.model.element.VariableElement;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/8 0008 15:45
 */
public class FolderStruct {
    public static void main(String[] args) {
        String[] arr= { "b\\cst", "d\\", "a\\d\\e", "a\\b\\c" };
        print(arr);

    }

    private static void print(String[] arr) {
        //构建目录前缀树 
        SturctTree root =  generate(arr);
        printTree(root,0);
        
    }

    private static void printTree(SturctTree root, int level) {
        if(level!=0){
            System.out.println(getSpace(level)+root.name);
        }
        for (SturctTree value : root.treeMap.values()) {
            printTree(value,level+1);
        }
    }

    private static String getSpace(int level) {
        StringBuilder buffer = new StringBuilder("");
        for(int i=0;i<level;i++){
            buffer.append(" ");
        }
        return buffer.toString();
    }

    private static SturctTree generate(String[] arr) {
        SturctTree root = new SturctTree("");
        for (String s : arr) {
            String[] split = s.split("\\\\");
            SturctTree cur = root;
            for (String s1 : split) {
                if(!cur.treeMap.containsKey(s1)){
                    cur.treeMap.put(s1,new SturctTree(s1));
                }
                cur = cur.treeMap.get(s1);
            }
            cur = root;
        }
        return root;
    }

    public static class SturctTree{
        public String name;
        public TreeMap<String,SturctTree> treeMap;

        public SturctTree(String name) {
            this.name = name;
            treeMap = new TreeMap<>();
        }
    }
}
