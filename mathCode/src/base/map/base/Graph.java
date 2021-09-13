package base.map.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/2/20 0020 13:30
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
