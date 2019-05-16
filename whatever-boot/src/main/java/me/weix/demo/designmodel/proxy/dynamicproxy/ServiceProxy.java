package me.weix.demo.designmodel.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/26
 * @Description:
 */
public class ServiceProxy implements InvocationHandler {

    private Service target;

    public ServiceProxy(Service target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("--------------------begin");
        Object result = method.invoke(target, args);
        System.out.println("--------------------end");
        return result;
    }

    public Object getProxy(){

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        Class<?> proxyClass = Proxy.getProxyClass(loader, interfaces);
        //返回动态生成的代理类实例
        return Proxy.newProxyInstance(loader,interfaces,this);
    }

    public static void main(String[] args) {
    //    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Service service = new ServiceImpl();
        ServiceProxy handler = new ServiceProxy(service);
        Service serviceProxy = (Service)handler.getProxy();
        serviceProxy.request();
    }
}
