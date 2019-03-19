package me.weix.demo.designmodel.chain;

/**
 * manager可以处理20%以内的折扣
 * @author weix
 * @date 2018/12/7 10:49
 */
public class Manager extends Handler {
    @Override
    public void handle(double discount) {

        if(discount < 0.2) {
            System.out.println("manager deal request");
        } else {
            System.out.println("转交boss");
            handler.handle(discount);
        }
    }
}
