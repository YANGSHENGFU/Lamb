package com.designpattern.prototype;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 克隆：是指克隆对象，在堆空间复制一块内存，克隆出来的对象和原型对象是两个不同的对象（地址空间不同，即不是同一个对象）。
 * 克隆分浅克隆和深克隆。
 * <p>
 * 浅克隆：仅仅复制所克隆的对象，而不复制它变量为引用的对象。被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
 * 总结：浅克隆仅仅复制所考虑的对象，而不复制它所引用的对象。
 * <p>
 * 深克隆：把要复制的对象所引用的对象都复制了一遍。即那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。
 * 总结：深克隆把要复制的对象所引用的对象(以及引用的引用)都复制了一遍。
 * <p>
 * 深克隆的实现
 * 1。根据定义：深克隆把要复制的对象所引用的对象都复制了一遍，所以引用类也实现Cloneable接口，重写clone方法。
 * 在对象clone的时候，给克隆出来的对象的引用对象赋值（调用引用类的克隆方法）
 * <p>
 * 2。使用序列化，利用序列化的特点。写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。可以利用这个特性，可以做深克隆。
 */
public class DeepClone implements Serializable {

    private String TAG = "DeepClone";
    private XiaoA xiaoA = new XiaoA("xiaoA", 25, new Limb(2, "双手"));

    public void deepCloen() {
        try {
            Log.d(TAG, "xiaoA : " + xiaoA);
            XiaoA xiaoB = xiaoA.clone();
            Log.d(TAG, "xiaoB : " + xiaoB);
            xiaoA.name = "xiaoAa";
            xiaoA.age = 30;
            xiaoA.limb.zise = 4;
            xiaoA.limb.name = "双脚";
            Log.d(TAG, "xiaoA : " + xiaoA);
            Log.d(TAG, "xiaoB : " + xiaoB);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用序列化方法
     */
    public void deepCloenSerializable() {
        Log.d(TAG, "xiaoA : " + xiaoA);
        xiaoA.deepCloenSerializable();
        Log.d(TAG, "xiaoA : " + xiaoA);
    }


    private class XiaoA implements Cloneable, Serializable {

        private static final long serialVersionUID = 7991552226614088458L;

        private String name;
        private int age;
        private Limb limb;

        public XiaoA(String name, int age, Limb limb) {
            this.name = name;
            this.age = age;
            this.limb = limb;
        }


        /**
         * 克隆该对象时，给该对象引用的对象赋值
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        public XiaoA clone() throws CloneNotSupportedException {
            XiaoA xiaoB = (XiaoA) super.clone();
            xiaoB.limb = this.limb.clone();
            return xiaoB;
        }

        /**
         * 使用序列化方法
         */
        public void deepCloenSerializable() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutput = new ObjectOutputStream(byteArrayOutputStream);
                objectOutput.writeObject(this);

                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                XiaoA xiaoA = (XiaoA) objectInputStream.readObject();
                xiaoA.age = 50;
                xiaoA.name = "xiaoB";
                xiaoA.limb.zise = 10;
                xiaoA.limb.name = "一双麒麟臂";
                Log.d(TAG, "xiaoB : " + xiaoA);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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

    /**
     * 1。引用类也是实现cloneable接口。
     * 2。重写clone方法。
     */
    private class Limb implements Cloneable, Serializable {
        private static final long serialVersionUID = 7991552226614088467L;
        private int zise;
        private String name;

        public Limb(int zise, String name) {
            this.zise = zise;
            this.name = name;
        }

        @Override
        public Limb clone() throws CloneNotSupportedException {
            return (Limb) super.clone();
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
