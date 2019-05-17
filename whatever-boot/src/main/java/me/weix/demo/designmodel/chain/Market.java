package me.weix.demo.designmodel.chain;

/**
 * market 可以处理了10%以内的折扣
 * @author weix
 * @date 2018/12/7 10:49
 */
public class Market extends Handler {
    @Override
    public void handle(double discount) {
        if(discount < 0.1) {
            System.out.println("market deal request");
        } else {
            System.out.println("转交manager");
            handler.handle(discount);
        }
    }
}
