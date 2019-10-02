package com.designpattern.factory;

/**
 * 工厂方法的代码升级版本，利用反射，当产品数量增加时，不用增加具体工厂类。但是利用反射会有一定的新能消耗。
 */
public class FactoryMethodReflex {

    public <T extends Animal> T getAnimal(Class<T> tClass){

        if(tClass==null){
            return null;
        }
        String mname = tClass.getName();
        Animal animal = null ;
        try {
            animal = (Animal) Class.forName(mname).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) animal;
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
