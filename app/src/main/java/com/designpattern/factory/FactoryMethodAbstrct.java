package com.designpattern.factory;

/**
 * 抽象工厂模式
 * 是工厂方法的升级版，当生成的产品是同一产品等级时，抽象工厂模式就退化为工厂方法模式。
 *
 */
public class FactoryMethodAbstrct {

    /**
     * 动物工厂
     */
    private interface AnimalFactory{
        Animal getAnimal();
        Grass getGrass();
    }

    public class CattleFactoey implements AnimalFactory {

        @Override
        public Cattle getAnimal() {
            return new Cattle();
        }

        @Override
        public Grass getGrass() {
            return new CattleGrass();
        }
    }


    public class SheepFactoey implements AnimalFactory {

        @Override
        public Sheep getAnimal() {
            return new Sheep();
        }

        @Override
        public Grass getGrass() {
            return new SheepGrass();
        }
    }


    public class HorseFactoey implements AnimalFactory {

        @Override
        public Horse getAnimal() {
            return new Horse();
        }

        @Override
        public Grass getGrass() {
            return new HorseGrass();
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

    private interface Grass{
        void grow();
    }

    private static class CattleGrass implements Grass{
        @Override
        public void grow() {

        }
    }


    private static class SheepGrass implements Grass{
        @Override
        public void grow() {

        }
    }


    private static class HorseGrass implements Grass{
        @Override
        public void grow() {

        }
    }

}
