package com.designpattern.singleton;

/**
 * 单例（Singleton）模式
 * 定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。
 *
 * 懒汉式：
 * 为了保存线程安全volatile和synchronized不能去掉
 * 但同时带来了缺点：每次调用getInstance方法都要同步，所以性能不是很好。
 *
 */
public class SingleCaseLazy {

    private static volatile SingleCaseLazy mInstance = null ; //保证 instance 在所有线程中同步
    /**
     * 私有的构造方法
     */
    private SingleCaseLazy(){
    }

    public static synchronized SingleCaseLazy getInstance(){
        if(mInstance == null ){
            mInstance = new SingleCaseLazy();
        }
        return mInstance ;
    }
}
