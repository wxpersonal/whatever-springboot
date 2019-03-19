package me.weix.demo.designmodel.chain;

/**
 * boss可以处理50%的折扣
 * @author weix
 * @date 2018/12/7 10:48
 */
public class Boss extends Handler {

    @Override
    public void handle(double discount) {
        if(discount < 0.5) {
            System.out.println("boss handle request");
        } else {
            System.out.println("boss refuse request");
        }
    }
}
