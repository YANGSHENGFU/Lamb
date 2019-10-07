package com.designpattern.flyweight;

import android.util.Log;
import java.util.HashMap;

/**
 * 享元模式：运用共享技术来有効地支持大量细粒度对象的复用。
 * 它通过共享已经存在的又橡来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率。
 *
 * 享元模式中存在以下两种状态：
 * 1。内部状态，即不会随着环境的改变而改变的可共享部分。
 * 2。外部状态，指随环境改变而改变的不可以共享的部分。享元模式的实现要领就是区分应用中的这两种状态，并将外部状态外部化。
 *
 * 模式结构
 * 1。抽象享元角色（Flyweight）:是所有的具体享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入。（即共享信息）
 * 2。具体享元（Concrete Flyweight）角色：实现抽象享元角色中所规定的接口。
 * 3。非享元（Unsharable Flyweight)角色：是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。（即外部信息）
 * 4。享元工厂（Flyweight Factory）角色：负责创建和管理享元角色。
 * 当客户对象请求一个享元对象时，享元工厂检査系统中是否存在符合要求的享元对象，如果存在则提供给客户；如果不存在的话，则创建一个新的享元对象。\
 *
 * 缺点：分析下面的代码可以看到，当增加一种激具体的享元角色时，工厂类得修改，违背了开闭原则。
 *
 */
public class FlyweightPattern {

    private String TAG = "FlyweightPattern";

    /**
     * 抽象享元角色（内部状态）
     */
    interface Flyweight{
        void share(UnsharableFlyweight unsharableFlyweight);
    }

    class ConcreteFlyweightA implements Flyweight{
        String ksy = "A";
        public ConcreteFlyweightA(){

        }

        @Override
        public void share(UnsharableFlyweight unsharableFlyweight) {
            Log.d(TAG , "ConcreteFlyweightA share");
            unsharableFlyweight.alonePossess();
        }
    }

    class ConcreteFlyweightB implements Flyweight{
        String ksy = "B";
        public ConcreteFlyweightB(){

        }

        @Override
        public void share(UnsharableFlyweight unsharableFlyweight) {
            Log.d(TAG , "ConcreteFlyweightB share");
            unsharableFlyweight.alonePossess();
        }
    }

    /**
     * 非享元角色(外部状态)
     */
    class UnsharableFlyweight{
        void alonePossess(){
            Log.d(TAG , "UnsharableFlyweight alonePossess");
        }
    }

    /**
     * 工厂类
     */
    class FlyweightFactory{
        HashMap<String , Flyweight> flyweightHashMap;
        public FlyweightFactory(){
            flyweightHashMap = new HashMap<>();
        }

        public Flyweight getFlyweight(String key){
            Flyweight flyweight = flyweightHashMap.get(key);
            if(flyweight == null){
                if("A".equals(key)){
                    flyweight = new ConcreteFlyweightA();
                } else if("B".equals(key)){
                    flyweight = new ConcreteFlyweightB();
                }
                flyweightHashMap.put(key , flyweight);
            } else {
                Log.d(TAG , "key 对应的对象已经存在");
            }
            return flyweight ;
        }
    }

    /**
     * 客户端测试代码
     */
    public void flyweightPatternTest(){
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight1 = flyweightFactory.getFlyweight("A");
        Flyweight flyweight2 = flyweightFactory.getFlyweight("A");
        Flyweight flyweight3 = flyweightFactory.getFlyweight("B");
    }
}
