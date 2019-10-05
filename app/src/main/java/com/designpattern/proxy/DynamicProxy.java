package com.designpattern.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 将代理分为静态代理和动态代理。编译时就确定了被代理的类是哪一个，那么就可以直接使用静态代理；运行时才确定被代理的类是哪个，那么可以使用类动态代理。
 *
 *注：JDK动态代理需要借助接口来实现，如果我们要代理的对象功能没有抽成任何接口，那么我们就无法通过JDK动态代理的方式来实现。
 *
 * 实现动态代理一定要用到的一个接口InvocationHandler和一个类Proxy
 *
 * 1。InvocationHandler：
 * 当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。
 * 所以实现InvocationHandler的类并不是真正的代理类，而是用于定义代理类需要扩展、增强那些方法功能的类。
 *
 * 2。StaticProxy：
 * 这个类的作用就是用来动态创建一个代理对象的类，它提供了许多的方法，但用的最多的就是 newProxyInstance 这个方法：
 *
 * 使用场景
 * 当想要给实现了某个接口的类中的方法，加一些额外的处理。所以被代理类一定要实现至少一个接口。
 *
 */
public class DynamicProxy {

    private String TAG = DynamicProxy.class.getSimpleName();

    interface SubjectA{
        void findRoom(String s);
        int purchase();
    }

    interface SubjectB{
        void plan(String s);
    }

    /**
     * 目标类
     */
    class RealSubject implements SubjectA , SubjectB{

        @Override
        public void findRoom(String s) {
            Log.d(TAG , "findRoom  找房 s : "+ s);
        }

        @Override
        public int purchase() {
            return 20 ;
        }

        @Override
        public void plan(String s) {
            Log.d(TAG , "findRoom  策划 s : "+ s);
        }
    }

    /**
     * 代理类的辅助定义和扩展类
     */
    class SubjectInvocationHandler implements InvocationHandler{

        SubjectA realSubject ;

        SubjectInvocationHandler( SubjectA subject){
            realSubject = subject ;
        }

        /**
         * @param proxy 指代生成的代理对象；
         * @param method 指代的是我们所要调用真实对象的某个方法的Method对象；
         * @param args 指代的是我们所要调用真实对象的某个方法的Method对象；
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            // 添加代理前的扩展

            if(method.getName().equals("purchase")){
                int s = (int) method.invoke(realSubject , args);
                Log.d(TAG , "invoke s : "+ s);
                return  s ;
            } else {
                Object object = method.invoke(realSubject , args);
            }

            // 添加代理后的扩展

            return null ;
        }
    }


    public void dynamicProxyTest(){
        RealSubject realSubject = new RealSubject();

        SubjectInvocationHandler invocationHandler = new SubjectInvocationHandler(realSubject);

        SubjectA proxyA = (SubjectA) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader() , realSubject.getClass().getInterfaces() , invocationHandler);

        proxyA.findRoom("碧桂园");
        int s = proxyA.purchase();

        if(proxyA instanceof SubjectB){
            ((SubjectB)proxyA).plan("方案一");
        }
    }


}
