package improve.动态规划;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/3/30 0030 12:30
 */
public class TestPow {
    public static void main(String[] args) {
        int k = 4;
        System.out.println(Math.pow(4,k) == (4<<k));
        System.out.println( (4<<k));
        System.out.println( Math.pow(4,k));
    }
}
