package design.策略者;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/26 0026 19:35
 */
public class PayTest {
    public static void main(String[] args) {
        String payChannel = "ALiPay";
       /* if(payChannel.equals("ALiPay")){
            new Alipay().process();
        }else if(payChannel.equals("WechatPay")){
            new Wechatpay().process();
        }else{
            new Bankpay().process();
        }*/

        PayChnnel match = PayChnnel.match(payChannel);
        PayChannel payChannel1 = match.payChannel;
        payChannel1.process();
    }
}
