package base.tree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/10 0010 20:11
 * 是否二叉搜索树
 * 方式1： 使用递归套路
 * 方式2： 使用中序遍历 找个preNode和curNode比较如果curNode<preNode 则return false
 *             5
 *          3       8
 *        2   4   7   10
 *     1        6   9   11
 *
 */
public class IsBst {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(5);
        head.right = new Node(9);

        // boolean isBsf = isBST(head);
         boolean isBsf = isBST2(head).isBsf();
        System.out.println("是否二叉搜索树");
        System.out.println(isBsf);
        System.out.println("采用mirros遍历是否Bsf");
        boolean bstMirros = isBstMirros(head);
        System.out.println(bstMirros);

    }


    static class ReturnData{
          int max;
          int min;

        public boolean isBsf() {
            return isBsf;
        }
        boolean isBsf;

        public ReturnData(int max, int min, boolean isBsf) {
            this.max = max;
            this.min = min;
            this.isBsf = isBsf;
        }
    }
    /**
     * 采用树的套路方式解决
     * @param head
     * @return ReturnData
     */
    private static ReturnData isBST2(Node head) {
      if(head==null){
          return null;
      }
        ReturnData left = isBST2(head.left);
        ReturnData right = isBST2(head.right);
        Integer min = head.value;
        Integer max = head.value;
        if(left!=null){
            min = left.min;
            max = left.max;
        }
        if(right!=null){
            min = right.min;
            max = right.max;
        }
        boolean isBst = true;
        if(left!=null){
            if(!left.isBsf || left.max>head.value){
                isBst = false;
            }
        }
        if(right!=null){
            if(!right.isBsf || right.min<head.value){
                isBst = false;
            }
        }
        return new ReturnData(max,min,isBst);
    }

    /**
     * 使用中序遍历+记录上个节点方式
     * @param head
     * @return
     */
    private static int pre = Integer.MIN_VALUE;
    private static boolean isBST(Node head) {
       if(head==null){
           return true;
       }
        boolean left = isBST(head.left);

        if(left){
           if(head.value<pre){
               return false;
           }else{
               pre = head.value;
           }
       }
        return isBST(head.right);
    }

    public static boolean isBstMirros(Node head){
        if(head == null){
            return true;
        }

        Node cur = head;
        Node mostRight = null;
        int pre = Integer.MIN_VALUE;
        while(cur!=null){
            mostRight = cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null && mostRight.right!=cur){

                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            //中序遍历处理逻辑
            if(pre >= head.value){
                return false;
            }
            pre = head.value;

            cur = cur.right;
        }
        return true;
    }
}
