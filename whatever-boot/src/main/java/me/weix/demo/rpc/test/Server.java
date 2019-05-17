package me.weix.demo.rpc.test;

import me.weix.demo.rpc.RpcServer;
import me.weix.demo.rpc.test.service.TestServiceImpl;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Server {

    public static void main(String[] args) {

        RpcServer server = new RpcServer() ;
        server.registService(new TestServiceImpl()) ;
        server.startServer(8080) ;

    }
}
