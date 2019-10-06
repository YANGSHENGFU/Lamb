package com.designpattern.decorator;

import android.util.Log;

/**
 * 装饰者模式：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。
 * <p>
 * 模式结构：
 * 1。抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 2。具体构件（Concrete Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。（被包装的角色）
 * 3。抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件（被装饰者）的实例，可以通过其子类扩展具体构件的功能。
 * 4。具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class DecoratorPattern {

    private String TAG = "DecoratorPattern";

    /**
     * 抽象构建
     */
    interface Component {
        void operation();
    }

    /**
     * 具体构建
     */
    class ConcreteComponent implements Component {

        @Override
        public void operation() {
            Log.d(TAG, "具体构建的方法");
        }
    }

    /**
     * 抽象装饰
     * 有具体构建的引用
     */
    class Decorator implements Component {

        Component mComponent;

        public Decorator(Component component) {
            mComponent = component;
        }

        @Override
        public void operation() {
            mComponent.operation();
        }
    }

    /**
     * 具体装饰者
     */
    class ConcreteDecorator extends Decorator {

        public ConcreteDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            addedFunction();
        }

        public void addedFunction() {
            Log.d(TAG, "具体装饰者的方法");
        }
    }


}
