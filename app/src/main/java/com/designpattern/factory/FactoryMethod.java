package com.designpattern.factory;

/**
 * 工厂方法模式
 * 满足开闭原则，当增加一种动物时，定义相应的具体工厂就可以。这样带来的麻烦就是要新定义具体工厂类。工厂方法模式代码升级版本，利用反射。
 * 所以当产品固定不在变化时，可以用工厂方法模式的退化版本，简单工厂。
 *
 * 工厂方法模式生成的产品是同一个产品等级的。
 * 产品等级：java中一个接口可以叫一个产品等级
 * 产品族：多个产品等级（多个接口）组成产品族。
 *
 * 所以当需要生成多个不同的产品等级的产品时（产品族）工厂方法就不使用了，需要使用升级版本，抽像工厂模式
 *
 */
public class FactoryMethod {

    /**
     * 动物工厂
     */
    private interface AnimalFactory{
        Animal getAnimal();
    }


    public class CattleFactoey implements AnimalFactory{

        @Override
        public Cattle getAnimal() {
            return new Cattle();
        }
    }


    public class SheepFactoey implements AnimalFactory{

        @Override
        public Sheep getAnimal() {
            return new Sheep();
        }
    }


    public class HorseFactoey implements AnimalFactory{

        @Override
        public Horse getAnimal() {
            return new Horse();
        }
    }



    /**
     * 动物
     */
    private interface Animal{
        void move();
    }

    /**
     * 牛
     */
    private static class Cattle implements Animal {

        @Override
        public void move() {

        }
    }

    /**
     * 羊
     */
    private static class Sheep implements Animal {

        @Override
        public void move() {

        }
    }

    /**
     * 马
     */
    private static class Horse implements Animal {

        @Override
        public void move() {

        }
    }

}
