package base.map.others;

import java.util.ArrayList;
import java.util.List;

import base.map.base.Edge;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 13:27
 */
public class Node {
    public int value;
    public List<Node> nexts;
    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
    }
}
