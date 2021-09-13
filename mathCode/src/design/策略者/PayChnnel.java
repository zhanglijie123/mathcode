package design.策略者;


/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/7/26 0026 19:30
 */

public enum PayChnnel  {
    ALiPay("ALiPay",new Alipay()),
    WechatPay("WechatPay",new Wechatpay()),
    BankPay("BankPay",new Bankpay());
    public String channelName;
    public PayChannel payChannel;

    PayChnnel(String channelName, PayChannel payChannel) {
        this.channelName = channelName;
        this.payChannel = payChannel;
    }

    public static PayChnnel match(String payChannel) {
        PayChnnel[] values = PayChnnel.values();
        for (PayChnnel value : values) {
            if(value.name().equals(payChannel)){
                return value;
            }
        }
        return null;
    }
}
