package com.designpattern.builder;

/**
 * 建造者模式的定义：指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示。
 * 它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 *
 * 建造者模式和工厂模式的关注点不同：建造者模式注重零部件的组装过程，而工厂方法模式更注重零部件的创建过程，但两者可以结合使用。
 *
 * 模式的结构
 * 1。产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个子部件。
 * 2。抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 3。具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 4。指挥者（Director）：它调用建造者对象中的部件构造与装配方法（步骤&顺序）完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 *
 * 应用场景
 * 建造者（Builder）模式创建的是复杂对象，其产品的各个部分经常面临着剧烈的变化，但将它们组合在一起的算法却相对稳定，所以它通常在以下场合使用。
 * 创建的对象较复杂，由多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的。
 * 创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的。
 *
 * 模式的扩展
 * 建造者（Builder）模式在应用过程中可以根据需要改变，如果创建的产品种类只有一种，只需要一个具体建造者，这时可以省略掉抽象建造者，甚至可以省略掉指挥者角色。
 *
 */
public class BuilderPattern {


    /**
     * 产品类
     */
    private class Computer{

        private String cpu;
        private String gpu;
        private String soundCard ;
        private String monitor;

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public String getGpu() {
            return gpu;
        }

        public void setGpu(String gpu) {
            this.gpu = gpu;
        }

        public String getSoundCard() {
            return soundCard;
        }

        public void setSoundCard(String soundCard) {
            this.soundCard = soundCard;
        }

        public String getMonitor() {
            return monitor;
        }

        public void setMonitor(String monitor) {
            this.monitor = monitor;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "cpu='" + cpu + '\'' +
                    ", gpu='" + gpu + '\'' +
                    ", soundCard='" + soundCard + '\'' +
                    ", monitor='" + monitor + '\'' +
                    '}';
        }
    }

    /**
     * 抽象建造者
     */
    private abstract class AbstractBuilder{
        Computer computer = new Computer();
        abstract void productionCPU(); // cup
        abstract void productionGPU(); // gpu
        abstract void productionSoundCard(); // 声卡
        abstract void productionMonitor(); // 显示器
        Computer getResult(){
            return computer ;
        }
    }

    /**
     * 具体建造者
     */
    private class DELLBuilder extends AbstractBuilder {

        @Override
        void productionCPU() {
            computer.setCpu("戴尔CPU");
        }

        @Override
        void productionGPU() {
            computer.setGpu("戴尔显卡");
        }

        @Override
        void productionSoundCard() {
            computer.setSoundCard("戴尔声卡");
        }

        @Override
        void productionMonitor() {
            computer.setMonitor("戴尔显示器");
        }
    }

    /**
     * 具体建造者
     */
    private class MACBuilder extends AbstractBuilder {

        @Override
        void productionCPU() {
            computer.setCpu("MACCPU");
        }

        @Override
        void productionGPU() {
            computer.setGpu("MAC显卡");
        }

        @Override
        void productionSoundCard() {
            computer.setSoundCard("MAC声卡");
        }

        @Override
        void productionMonitor() {
            computer.setMonitor("MAC显示器");
        }
    }

    /**
     * 指挥者
     */
    private class DirectorDell{

        AbstractBuilder builder;

        public DirectorDell(AbstractBuilder builder){
           this.builder = builder;
        }

        public Computer assemblingDell(){
            builder.productionCPU();
            builder.productionGPU();
            builder.productionSoundCard();
            builder.productionMonitor();
            return builder.getResult();
        }


    }
}
