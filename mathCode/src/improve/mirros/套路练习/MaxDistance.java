package improve.mirros.套路练习;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/7 0007 20:04
 * 求树的最大距离 （两个节点距离多少）
 */
public class MaxDistance {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(maxDistanceProcess(head1).maxDistance-1);
    }

    public static class ReturnData{
        private int height;
        private int maxDistance;

        public ReturnData(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }
    private static ReturnData maxDistanceProcess(Node head) {
        if(head==null){
            return new ReturnData(0,0);
        }
        ReturnData left = maxDistanceProcess(head.left);
        ReturnData right = maxDistanceProcess(head.right);
        int p = left.maxDistance;
        int p2 = right.maxDistance;
        int p3 = left.height+right.height+1;
        int hi = Math.max(left.height,right.height)+1;
        p3=Math.max(p3,Math.max(p,p2));
        return new ReturnData(hi,p3);

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
