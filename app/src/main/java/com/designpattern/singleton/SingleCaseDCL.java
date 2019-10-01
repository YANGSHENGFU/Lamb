package com.designpattern.singleton;

/**
 * 懒汉式的升级版
 */
public class SingleCaseDCL {

    private static SingleCaseDCL mInstance = null ;

    private SingleCaseDCL(){
    }

    public static SingleCaseDCL getInstance(){
        if(mInstance==null){
           synchronized (SingleCaseDCL.class){
               if(mInstance ==null){
                   mInstance = new SingleCaseDCL();
               }
           }
        }
        return mInstance;
    }
}
