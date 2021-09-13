package design.策略者;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/26 0026 19:29
 */
public class Alipay implements  PayChannel{
    @Override
    public void process() {
        System.out.println("支付宝支付.......");
    }
}
