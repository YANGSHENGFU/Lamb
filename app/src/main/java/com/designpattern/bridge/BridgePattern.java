package com.designpattern.bridge;

import android.util.Log;

/**
 * 桥接模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 *
 * 模式结构
 * 1。抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。（使用聚合关系）
 * 2。扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * 3。实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 * 4。具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 * 抽象化包含实现化对象的引用，使用聚合关系。将抽像化和实现化的分开互补影响。
 */
public class BridgePattern {

    private String TAG = "BridgePattern";

    /**
     * 实现化角色
     */
    interface Implementor{
        void open();
    }

    /**
     * 具体实现化角色
     */
    class ConcreteImplementorA implements Implementor{

        @Override
        public void open() {
            Log.d(TAG , "ConcreteImplementorA open ");
        }
    }

    /**
     * 具体是实现化角色
     */
    class ConcreteImplementorB implements Implementor{

        @Override
        public void open() {
            Log.d(TAG , "ConcreteImplementorB open ");
        }
    }

    /**
     * 抽象化角色
     * 1.包含实现化角色对象的引用
     */
    abstract class Abstraction{
        Implementor mImplementor ;
        public Abstraction(Implementor implementor){
            mImplementor = implementor ;
        }

        abstract void open();
    }

    /**
     * 具体抽象化角色
     */
    class RefinedAbstractionA extends Abstraction{
        public RefinedAbstractionA(Implementor implementor) {
            super(implementor);
        }

        @Override
        void open() {
            Log.d(TAG , "RefinedAbstractionA open ");
            mImplementor.open();
        }
    }

    /**
     * 具体抽象化角色
     */
    class RefinedAbstractionB extends Abstraction{

        public RefinedAbstractionB(Implementor implementor) {
            super(implementor);
        }

        @Override
        void open() {
            Log.d(TAG , "RefinedAbstractionB open ");
            mImplementor.open();
        }
    }

    /**
     * 客户端测试代码
     */
    public void bridgePatternTest(){
        RefinedAbstractionA refinedAbstractionA = new RefinedAbstractionA(new ConcreteImplementorA());
        RefinedAbstractionA refinedAbstractionB = new RefinedAbstractionA(new ConcreteImplementorB());
        RefinedAbstractionB refinedAbstractionAA = new RefinedAbstractionB(new ConcreteImplementorA());
        RefinedAbstractionB refinedAbstractionBB = new RefinedAbstractionB(new ConcreteImplementorB());
        refinedAbstractionA.open();
        refinedAbstractionB.open();
        refinedAbstractionAA.open();
        refinedAbstractionBB.open();
    }
}
