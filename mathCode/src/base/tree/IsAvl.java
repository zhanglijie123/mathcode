package base.tree;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/1/11 0011 9:40
 */
public class IsAvl {

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
        // head.left.right.left = new Node(4);//这行注释打开就不是avl
        System.out.println("是否avl树");
        ReturnData avl = isAvl(head);
        System.out.println(avl.isAVL);

    }
   static class ReturnData{
        private int height;
        private boolean isAVL;

       public boolean isAVL() {
           return isAVL;
       }

       public ReturnData(int height, boolean isAVL) {
           this.height = height;
           this.isAVL = isAVL;
       }
   }
   private static ReturnData isAvl(Node head) {
         if(head == null){
             return new ReturnData(0,true);
         }
       ReturnData left = isAvl(head.left);
       ReturnData right = isAvl(head.right);
       int hight = Math.max(left.height,right.height)+1;
       boolean isAVL =  left.isAVL && right.isAVL &&(Math.abs(left.height-right.height)<2);
       return new ReturnData(hight,isAVL);

   }

}
