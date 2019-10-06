package com.designpattern.bridge;

import android.util.Log;

/**
 * 桥接模式扩展：
 * 当桥接（Bridge）模式的实现化角色的接口与现有类的接口不一致时，可以在二者中间定义一个适配器将二者连接起来。
 * 模式结构
 * 1。抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。（使用聚合关系）
 * 2。扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * 3。实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 * 4。具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 * 抽象化包含实现化对象的引用，使用聚合关系。将抽像化和实现化的分开互补影响。
 */
public class BridgePatternExtend {

    private String TAG = "BridgePatternExtend";
    /**
     * 实现化
     */
    interface Implementor{
        void open();
    }

    class ConcreteImplementoA implements Implementor{
        @Override
        public void open() {
            Log.d(TAG , "ConcreteImplementoA open ");
        }
    }

    class ConcreteImplementoB implements Implementor{
        @Override
        public void open() {
            Log.d(TAG , "ConcreteImplementoB open ");
        }
    }

    /**
     * 抽象化
     */
    abstract class Abstraction{

        private Implementor mImplementor;

        public Abstraction(Implementor implementor){
            mImplementor = implementor;
        }

        abstract void open();
    }

    class ConcreteImplementorA extends Abstraction{

        public ConcreteImplementorA(Implementor implementor) {
            super(implementor);
        }

        @Override
        void open() {
            Log.d(TAG , "ConcreteImplementorA open ");
        }
    }

    class ConcreteImplementorB extends Abstraction{

        public ConcreteImplementorB(Implementor implementor) {
            super(implementor);
        }

        @Override
        void open(){
            Log.d(TAG , "ConcreteImplementorB open ");
        }
    }

    /**
     * 适配者
     * 系统原型有的类，真正想使用的类
     */
    class Adatee{
        void open(){
            Log.d(TAG , "open open ");
        }
    }

    /**
     * 适配器
     */
    class ObjectAdapterA extends ConcreteImplementoA{

        Adatee mAdatee ;

        public ObjectAdapterA(Adatee adatee){
            mAdatee = adatee ;
        }

        @Override
        public void open(){
            Log.d(TAG , "ObjectAdapterA open ");
            super.open();
            mAdatee.open();
        }
    }

    /**
     * 适配器
     */
    class ObjectAdapterB extends ConcreteImplementoB{

        Adatee mAdatee ;

        public ObjectAdapterB(Adatee adatee){
            mAdatee = adatee ;
        }

        @Override
        public void open(){
            Log.d(TAG , "ObjectAdapterB open ");
            super.open();
            mAdatee.open();
        }

    }

    /**
     * 客户端测试代码
     */
    public void bridgePatternExtendTest() {
        ConcreteImplementorA a = new ConcreteImplementorA(new ObjectAdapterA(new Adatee()));
        ConcreteImplementorB b = new ConcreteImplementorB(new ObjectAdapterB(new Adatee()));
        a.open();
        b.open();
    }
}
