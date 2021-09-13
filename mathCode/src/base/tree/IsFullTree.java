package base.tree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/11 0011 10:16
 * 验证是否满二叉树
 */
public class IsFullTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right.left = new Node(2);
        head.right.right = new Node(4);
        //  head.left.right.left = new Node(4);//这行注释打开就不是fullTree
        System.out.println("是否满二叉树");
        ReturnData returnData = isFullTree(head);
        if(returnData.getNodes() == ((1 << returnData.getHeight())-1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


    }

    private static ReturnData isFullTree(Node head) {
      if(head==null){
          return new ReturnData(0,0);
      }
        ReturnData left = isFullTree(head.left);
        ReturnData right = isFullTree(head.right);
        int hi = Math.max(left.height,right.height)+1;
        int nodes = left.nodes+right.nodes+1;
        return new ReturnData(hi,nodes);
    }

    static class ReturnData{
        private int height;//高度

        public ReturnData(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }

        public int getHeight() {
            return height;
        }

        public int getNodes() {
            return nodes;
        }

        private int nodes;//节点个数
       
    }
}
