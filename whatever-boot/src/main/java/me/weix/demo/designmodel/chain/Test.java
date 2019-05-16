package me.weix.demo.designmodel.chain;

/**
 * 为某个请求创建一个对象链, 每个对象依序检查此请求并对其进行处理或者将它传给链中的下一个对象
 * @author weix
 * @date 2018/12/7 10:53
 */
public class Test {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setHandler(Handler.createHander(new Boss()));

        customer.getHandler().handle(0.4);
    }
}
