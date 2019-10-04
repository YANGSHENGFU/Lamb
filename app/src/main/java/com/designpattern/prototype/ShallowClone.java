package com.designpattern.prototype;

import android.util.Log;

/**
 * 克隆：是指克隆对象，在堆空间复制一块内存，克隆出来的对象和原型对象是两个不同的对象（地址空间不同，即不是同一个对象）。
 * 克隆分浅克隆和深克隆。
 * 浅克隆：仅仅复制所克隆的对象，而不复制它变量为引用的对象。被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
 * 总结：浅复制仅仅复制所考虑的对象，而不复制它所引用的对象。
 *
 *
 * 深克隆：把要复制的对象所引用的对象都复制了一遍。即那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。
 * 总结：深复制把要复制的对象所引用的对象都复制了一遍。
 *
 *
 * 很明显二者时间消耗有差距，在不影响的情况下尽量用浅克隆
 *
 * 浅克隆的实现
 * 1。利用Object类的clone方法，重写clone方法，调用super.clone();
 * 2。类实现Clone接口，表示此类的对象可以clone
 */

public class ShallowClone {

    private String TAG = "ShallowClone" ;

    private XiaoA xiaoA = new XiaoA("xiaoA" , 25 , new Limb(2 , "四肢"));

    public void cloen(){
        try {
            Log.d(TAG , "xiaoA : "+ xiaoA);
            XiaoA xiaoB = xiaoA.clone();
            Log.d(TAG , "xiaoB : "+ xiaoB);
            xiaoA.name = "xiaoC" ;
            xiaoA.age = 30 ;
            xiaoA.limb.zise = 4 ;
            Log.d(TAG , "xiaoA : "+ xiaoA);
            Log.d(TAG , "xiaoB : "+ xiaoB);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private class XiaoA implements Cloneable{
        private String name;
        private int age;
        private Limb limb;

        public XiaoA(String name , int age , Limb limb){
            this.name = name ;
            this.age = age ;
            this.limb = limb ;
        }

        @Override
        public XiaoA clone() throws CloneNotSupportedException {
            return (XiaoA)super.clone();
        }

        @Override
        public String toString() {
            return "XiaoA{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", limb=" + limb +
                    '}';
        }
    }

    private class Limb {
        private int zise ;
        private String name ;

        public Limb(int zise, String name) {
            this.zise = zise;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Limb{" +
                    "zise=" + zise +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
