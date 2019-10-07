package com.designpattern.composite;

import android.util.Log;

import java.util.ArrayList;

/**
 * 组合模式：又叫作部分-整体模式，它是一种将对象组合成树状的层次结构的模式，用来表示“部分-整体”的关系，使用户对单个对象和组合对象具有一致的访问性。
 *
 * 模式结构：
 * 1。抽象构件（Component）角色：它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。
 * 在透明式的组合模式中抽象构件还声明访问和管理子类的接口；
 * 在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成。
 * 2。树叶构件（Leaf）角色：是组合中的叶节点对象，它没有子节点，用于实现抽象构件角色中声明的公共接口。
 * 3。树枝构件（Composite）角色：是组合中的分支节点对象，它有子节点。它实现了抽象构件角色中声明的接口，它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。
 *
 * 用来表示“部分-整体”的关系，使用户对单个对象和组合对象具有一致的访问性。单个对象：树叶构建对象。组合对象：树枝构建对象。
 *
 * 组合模式的主要优点有：
 * 组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；
 * 更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；
 *
 * (1) 透明方式：在该方式中，由于抽象构件声明了所有子类中的全部方法，所以客户端无须区别树叶对象和树枝对象，对客户端来说是透明的。
 * 但其缺点是：树叶构件本来没有 Add()、Remove() 及 GetChild() 方法，却要实现它们（空实现或抛异常），这样会带来一些安全性问题。
 *
 * (2) 安全方式：在该方式中，将管理子构件的方法移到树枝构件中，抽象构件和树叶构件没有对子对象的管理方法，
 * 这样就避免了上一种方式的安全性问题，但由于叶子和分支有不同的接口，客户端在调用时要知道树叶对象和树枝对象的存在，所以失去了透明性。
 *
 */
public class CompositePattern {

    private String TAG = "CompositePattern";

    /**
     * 抽象构建
     */
    interface Component{ //security
        void add(Component c);
        void remove(Component c);
        Component getChild(int i);
        void operation();
    }

    /**
     * 树叶构建
     * 没有子节点，所以add，remove，getChild方法都是空实现
     */
    class Leaf implements Component{

        String name ;

        public Leaf(String name){
            this.name = name;
        }

        @Override
        public void add(Component c) {

        }

        @Override
        public void remove(Component c) {

        }

        @Override
        public Component getChild(int i) {
            return null;
        }

        @Override
        public void operation() {
            Log.d(TAG , "operation name = "+name);
        }
    }

    /**
     * 树枝节点
     */
    class Composite implements Component{

        private ArrayList<Component> components ;
        private String name ;

        public Composite(String name){
            this.name = name ;
            components = new ArrayList<>();
        }

        @Override
        public void add(Component c) {
            components.add(c);
        }

        @Override
        public void remove(Component c) {
            components.add(c);
        }

        @Override
        public Component getChild(int i) {
            return components.get(i);
        }

        /**
         * 调用单个对象和调用组合对象一样的接口，所以用户看起来是一样的。
         */
        @Override
        public void operation() {
            Log.d(TAG , "operation name = "+name);
            for( Component component :components){
                component.operation();
            }
        }
    }

    /**
     * 透明式客户端测试代码
     */
    public void compositePatternTransparentTest(){
        Component component1 = new Composite("Node1");
        Component leaf1 = new Composite("Leaf1");
        Component component2 = new Composite("Node2");
        Component leaf2 = new Composite("Leaf2");
        Component leaf3 = new Composite("Leaf3");
        component1.add(leaf1);
        component1.add(component2);
        component2.add(leaf2);
        component2.add(leaf3);
        component1.operation();
    }

    // 安全模式

    /**
     * 抽象构建
     */
    interface ComponentSecurity{
        void operation();
    }

    /**
     * 树叶构建
     */
    class LeafSecurity implements ComponentSecurity{

        String name ;

        public LeafSecurity(String name){
            this.name = name;
        }

        @Override
        public void operation() {
            Log.d(TAG , "operation name = "+name);
        }
    }

    /**
     * 树枝节点
     */
    class CompositeSecurity<T extends ComponentSecurity> implements ComponentSecurity{

        private ArrayList<T > components ;
        private String name ;

        public CompositeSecurity(String name){
            this.name = name ;
            components = new ArrayList<>();
        }

        /**
         * 扩展方法
         * @param c
         */
        public void add(T c) {
            components.add(c);
        }

        /**
         * 扩展方法
         * @param c
         */
        public void remove(T c) {
            components.add(c);
        }

        /**
         * 扩展方法
         * @param i
         */
        public T getChild(int i) {
            return components.get(i);
        }

        /**
         * 调用单个对象和调用组合对象一样的接口，所以用户看起来是一样的。
         */
        @Override
        public void operation() {
            Log.d(TAG , "operation name = "+name);
            for( T compositeSecurity :components){
                compositeSecurity.operation();
            }
        }
    }

    /**
     * 透明式客户端测试代码
     */
    public void compositePatternSecurityTest(){
        CompositeSecurity component1 = new CompositeSecurity("Node1");
        ComponentSecurity leaf1 = new LeafSecurity("Leaf1");
        CompositeSecurity component2 = new CompositeSecurity("Node2");
        ComponentSecurity leaf2 = new LeafSecurity("Leaf2");
        ComponentSecurity leaf3 = new LeafSecurity("Leaf3");
        component1.add(leaf1);
        component1.add(component2);
        component2.add(leaf2);
        component2.add(leaf3);
        component1.operation();
    }
}
