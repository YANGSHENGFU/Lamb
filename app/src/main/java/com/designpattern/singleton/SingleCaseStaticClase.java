package com.designpattern.singleton;

/**
 * DCL的升级版本。使用static内部类
 * SingleCaseStaticClase类加载的时候不会加载SingleCase类，只有调用getInstace方法时才会加载SingleCase类，同时mInstace实例得到初始化，所以线程是安全的。
 */
public class SingleCaseStaticClase {

    public static SingleCase getInstace(){
        return SingleCase.mInstace ;
    }

    private static class SingleCase{
        private static SingleCase mInstace = new SingleCase();
    }
}
