package com.designpattern.singleton;

/**
 * 单例（Singleton）模式
 * 定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。
 *
 * 饿汉式
 * 由于对象在类加载就完成了创建，所以线程式安全的，但是正式由于在类加载阶段就完成了对象的创建，如果后面没有用到噶实例会造成内存浪费。
 */
public class SingleCaseHungry {

    private static SingleCaseHungry mInstance = new SingleCaseHungry(); //保证 instance 在所有线程中同步

    /**
     * 私有的构造方法
     */
    private SingleCaseHungry(){
    }

    public static synchronized SingleCaseHungry getInstance(){
        return mInstance ;
    }

}
