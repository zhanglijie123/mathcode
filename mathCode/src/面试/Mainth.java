package 面试;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/17 0017 10:18
 */
public class Mainth {

    public static void main(String[] args) throws ParseException {
       // System.out.println(ss);
        try {
            String[] list = {"01", "02", "03", "04"};
            Map map = new TreeMap<>();
            map.put(3, 3);
            map.put(3, 3);
            map.put(2, 2);
            map.put(4, 4);
            map.put(1, 1);
            for (Object o : map.keySet()) {
                System.out.println(map.get(o));
            }
            System.out.println(list[4]);
        }catch (Exception e){
            System.out.println("eerrr");
        }
    }

}
