package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工厂类
 */
public class WangMeiLiProxy implements InvocationHandler {
    private Girl girl;

    public WangMeiLiProxy(Girl girl){
        this.girl = girl;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomeThingBefore();//方法增强 在目标方法执行之前
        Object invoke = method.invoke(girl, args);
        doSomeThingAfter();//方法增强 在目标方法执行之后
        return invoke;
    }

    private void doSomeThingBefore(){
        System.out.println("增强方法  在方法执行之前需要干的事。。。。。。。");
    }

    private void doSomeThingAfter(){
        System.out.println("方法增强  在方法执行之后需要干的事。。。。。。。");
    }

    // 获取代理对象实例
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(),girl.getClass().getInterfaces(),this);
    }
}
