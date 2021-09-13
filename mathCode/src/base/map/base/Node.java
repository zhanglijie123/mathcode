package base.map.base;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 13:27
 */
public class Node {
    public int value;
    //入度
    public int in;
    //出度
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;
    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }
}
