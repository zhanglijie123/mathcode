package base.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/25 0025 15:18
 */
public class Half {
   public static  class HNode implements Comparable<HNode> {
        int value; // 节点的值
        HNode left; // 左右子节点的指针
        HNode right;

        public HNode(int value) {
            this.value = value;
        }

        // 前序遍历
        public void DLR() {
            System.out.println(this);// 先输出根节点
            // 左子树递归
            if (this.left != null) {
                this.left.DLR();
            }
            // 右子树递归
            if (this.right != null) {
                this.right.DLR();
            }
        }

        @Override
        public String toString() {
            return "HNode[value = " + value + "]";
        }

        @Override
        public int compareTo(HNode o) {
            return this.value - o.value; // 从小到大排序
        }
    }

    public static HNode create(int[] arr) {
        // 把数组的数据取出来放在节点类当中排序
        List<HNode> nodes = new ArrayList<HNode>();
        for (int value : arr) {
            nodes.add(new HNode(value));
        }
        while (nodes.size() > 1) {
            // 先进行排序
            Collections.sort(nodes);
            // System.out.println("nodes = "+ nodes);

            // 取出最小的俩个数据
            HNode leftnode = nodes.get(0);
            HNode rightnode = nodes.get(1);

            // 构建新的二叉树
            HNode parent = new HNode(leftnode.value + rightnode.value);
            parent.left = leftnode;
            parent.right = rightnode;

            // 从当中删除使用过的子节点
            nodes.remove(leftnode);
            nodes.remove(rightnode);

            // 把父节点加入进去
            nodes.add(parent);
        }
        // System.out.println("第一次处理后：" +nodes);
        return nodes.get(0);
    }
}
