package me.weix.demo.rpc.test;

import me.weix.demo.rpc.RpcClient;
import me.weix.demo.rpc.test.service.ITestServcie;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Client {

    public static void main(String[] args) {

        ITestServcie testServcie =
                RpcClient.findService("127.0.0.1" , 8080 , ITestServcie.class) ;
        String  result = testServcie.sayHello("is_zhoufeng");
        System.out.println(result );
    }
}
