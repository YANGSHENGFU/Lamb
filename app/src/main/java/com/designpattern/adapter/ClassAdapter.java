package com.designpattern.adapter;

import android.util.Log;

/**
 * 适配器：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作
 *
 * 分类：类适配器 ， 对象适配器。 类适配器耦合成都高一些，使用的是继承，对象适配器使用的是聚合。
 *
 * 模式的结构
 * 1。目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。客户点要使用（调用）的接口，但真正小调用的适配器的接口。
 * 2。适配者（Adaptee）类：它是被访问和适配（被适配）的现存组件库中的组件接口。
 * 3。适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 *
 * 即客户端有目标接口的引用，通过调用目标接口间接调用适配这的接口
 */
public class ClassAdapter {

    private String TAG = "ClassAdapter";

    /**
     * 目标接口 （客户端要调用的接口）
     */
    interface Target{
        void request();
    }

    /**
     * 适配者（被适配的类）
     */
    class Adaptee{
        public void specificRequest() {
           Log.i(TAG , "适配者中的业务代码被调用");
        }
    }

    /**
     * 适配器
     *
     * 类适配器使用的是继承。适配器继承适配者，即适配器拥有类适配者的能力。实现目标接口，客户端调用的是目标接口
     */
    class Adapter extends Adaptee implements Target{

        @Override
        public void request() {
            Log.i(TAG , "适配器中的业务代码被调用");
            specificRequest();
        }

    }

    /**
     * 客户端测试代码
     */
    public void classAdapterTest(){
        Target target = new Adapter();
        target.request();
    }



}
