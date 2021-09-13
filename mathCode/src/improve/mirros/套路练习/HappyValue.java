package improve.mirros.套路练习;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/7 0007 20:11
 * 快乐值
 */
public class HappyValue {
    public  static class Node{
        private int value;
        private Node[] nexts;

        public Node(int value, Node[] nexts) {
            this.value = value;
            this.nexts = nexts;
        }
    }
    public static int maxHappyValue(Node head){
        ReturnInfo info = process(head);
        return Math.max(info.buMaxHappy,info.laiMaxHappy);

    }

    private static ReturnInfo process(Node head) {
        if(head ==null){
            return new ReturnInfo(0,0);
        }
        int lai = head.value;
        int bu = 0;
        for(Node next:head.nexts){
            ReturnInfo process = process(next);
            lai+= process.buMaxHappy;
            bu+=Math.max(process.laiMaxHappy,process.buMaxHappy);
        }
        return new ReturnInfo(bu,lai);
    }

    public static class ReturnInfo{
        private int laiMaxHappy;
        private int buMaxHappy;

        public ReturnInfo(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

}
