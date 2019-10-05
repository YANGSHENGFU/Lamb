package com.designpattern.proxy;

/**
 * 静态代理模式：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。
 *
 * 模式的结构
 * 1。抽象目标（Target）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 * 2。具体目标（Specific Target）类：实现了抽象目标中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * 3。代理（StaticProxy）类：提供了与具体目标相同的接口（一般是继承了抽象目标类或实现类抽象目标接口），其内部含有对具体目标的引用，它可以访问、控制或扩展具体目标的功能。
 *
 * 缺点：
 * 代理类中包含了对真实主题（具体目标）的引用，这种方式存在两个缺点。
 * 真实主题与代理主题一一对应，增加真实主题也要增加代理。
 * 设计代理这前真实主题必须事先存在，不太灵活。采用动态代理模式可以解决以上问题
 *
 */
public class StaticProxy {

    /**
     * 目标接口
     */
    interface Target{
        void housePurchase();
    }

    /**
     * 具体目标类
     */
    class HousePurchase implements Target{
        @Override
        public void housePurchase() {

        }
    }

    /**
     * 代理类
     */
    class ShellHousePurchase implements Target{

        // 代理类持有目标类的引用
        Target target ;

        public ShellHousePurchase(Target target){ //传入具体目标类
            this.target = target;
        }

        @Override
        public void housePurchase() {
            understandNeeds(); // 扩展一
            target.housePurchase(); // 调用的还是真正的目标类的方法
            housePurchaseComplete(); // 扩展二
        }

        /**
         * 理解客户需求
         */
        private void understandNeeds(){

        }

        /**
         * 购房完成
         */
        private void housePurchaseComplete(){

        }
    }

    /**
     * 测试
     */
    public void  proxyTest(){
        ShellHousePurchase shellHousePurchase = new ShellHousePurchase(new HousePurchase());
        shellHousePurchase.housePurchase();
    }

}
