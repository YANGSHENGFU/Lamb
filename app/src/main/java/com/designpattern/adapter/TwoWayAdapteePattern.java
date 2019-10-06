package com.designpattern.adapter;

/**
 * 适配器模式的扩展：双向适配器
 * 双向适配器类既可以把适配者接口转换成目标接口，也可以把目标接口转换成适配者接口.
 */
public class TwoWayAdapteePattern {

    /**
     * 目标接口
     */
    interface TwoWayTarget {
        void request();
    }

    /**
     * 适配者接口
     */
    interface TwoWayAdaptee {
        void specificRequest();
    }

    /**
     * 目标实现
     */
    class TargetRealize implements TwoWayTarget {
        public void request() {
            System.out.println("目标代码被调用！");
        }
    }

    /**
     * 适配者实现
     */
    class AdapteeRealize implements TwoWayAdaptee {
        public void specificRequest() {
            System.out.println("适配者代码被调用！");
        }
    }

    /**
     * 双向适配器
     */
    class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
        private TwoWayTarget target;
        private TwoWayAdaptee adaptee;

        public TwoWayAdapter(TwoWayTarget target) {
            this.target = target;
        }

        public TwoWayAdapter(TwoWayAdaptee adaptee) {
            this.adaptee = adaptee;
        }

        // 目标接口的方法，调用适配者接口方法
        public void request() {
            adaptee.specificRequest();
        }

        // 适配者的方法，调用目标接口的方法
        public void specificRequest() {
            target.request();
        }
    }


}
