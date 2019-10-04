package com.designpattern.prototype;


import android.util.Log;

/**
 *
 * 学习原型模式先了解克隆知识（浅克隆&深克隆）
 *
 * 原型模式：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 * 在有些系统中，存在大量相同或相似对象的创建问题，如果用传统的构造函数来创建对象，会比较复杂且耗时耗资源，
 * 用原型模式生成对象就很高效，就像孙悟空拔下猴毛轻轻一吹就变出很多孙悟空一样简单。
 *
 * 原型模式的结构
 * 1。抽象原型类：规定了具体原型对象必须实现的接口（Cloneable接口表示他的对象是可以被克隆的）
 * 2。具体原型类：实现抽象原型接口。重写Object类的colne（）方法。
 * 3。访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 *
 */
public class Prototype {

    private String TAG = "Prototype";

    public void protoytpeTest(){
        Sheep sheep = new Sheep(2,"小羊");
        Log.d(TAG , "sheep : "+ sheep);
        Sheep sheepClone = sheep.clone();
        sheepClone.setAge(1);
        sheepClone.setName("多利");
        Log.d(TAG , "sheepClone : "+ sheepClone);
    }


    /**
     * 1。实现抽象原型Cloneable
     * 2。重写Object的clone()方法
     */
    private class Sheep implements Cloneable{

        private int age ;
        private String name ;

        public Sheep(int age , String name){
            this.age = age ;
            this.name = name ;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * 重写clone()方法
         * @return
         */
        @Override
        public Sheep clone(){
            try {
                return (Sheep) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null ;
        }

        @Override
        public String toString() {
            return "Sheep{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
