package me.weix.demo.rpc;


import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;


/**
 * @author weix
 */
public class RpcClient {

    /**
     * 根据接口类型得到代理的接口实现
     * @param <T>
     * @param host  RPC服务器IP
     * @param port  RPC服务端口
     * @param serviceInterface  接口类型
     * @return  被代理的接口实现
     */
    @SuppressWarnings("unchecked")
    public static <T> T findService(final String host , final int port ,final Class<T> serviceInterface){
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface}, new InvocationHandler() {
            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args)
                    throws Throwable {
                Socket socket = null ;
                InputStream is = null ;
                OutputStream os = null ;
                ObjectInput oi = null ;
                ObjectOutput oo = null ;
                try {
                    socket = new Socket(host, port) ;
                    os = socket.getOutputStream() ;
                    oo = new ObjectOutputStream(os);
                    oo.writeUTF(serviceInterface.getName()) ;
                    oo.writeUTF(method.getName()) ;
                    oo.writeObject(method.getParameterTypes()) ;
                    oo.writeObject(args);

                    is = socket.getInputStream() ;
                    oi = new ObjectInputStream(is) ;
                    return oi.readObject() ;
                } catch (Exception e) {
                    System.out.println("调用服务异常...");
                    return null ;
                }finally{
                    if(is != null){
                        is.close() ;
                    }
                    if(os != null){
                        os.close() ;
                    }
                    if(oi != null){
                        oi.close() ;
                    }
                    if(oo != null){
                        oo.close() ;
                    }
                    if(socket != null){
                        socket.close() ;
                    }
                }
            }
        });
    }

}
