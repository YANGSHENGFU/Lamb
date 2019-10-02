package com.designpattern.factory;

/**
 * 简单工程模式
 * 缺点：不满足开闭原则。没加一种动物，getAnimal方法都不修改。
 */
public class SimpleFactory {

    public static Animal getAnimal(String name){

        if(name.equals("cattle")){
            return new Cattle();
        } else if(name.equals("sheep")){
            return new Sheep();
        } else if(name.equals("horse")){
            return new Horse();
        }
        return null;
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
    private static class Cattle implements Animal{

        @Override
        public void move() {

        }
    }

    /**
     * 羊
     */
    private static class Sheep implements Animal{

        @Override
        public void move() {

        }
    }

    /**
     * 马
     */
    private static class Horse implements Animal{

        @Override
        public void move() {

        }
    }

}
