package com.designpattern.facade;

import android.util.Log;

/**
 * 外观模式的缺点：当增加或移除子系统时需要修改外观类，这违背了“开闭原则”。
 * 处理办法：定义一个外观接口，当增加或删减子系统时添加一个具体的外观类。
 */

public class FacadePatternExtend {

    private String TAG = "FacadePatternExtend";

    /**
     * 子系统
     */
    class SubSystem1 {
        public void open() {
            Log.i(TAG, "SubSystem1 open");
        }
    }

    class SubSystem2 {
        public void open() {
            Log.i(TAG, "SubSystem2 open");
        }
    }

    class SubSystem3 {
        public void open() {
            Log.i(TAG, "SubSystem3 open");
        }
    }

    class SubSystem4 {
        public void open() {
            Log.i(TAG, "SubSystem4 open");
        }
    }

    class SubSystem5 {
        public void open() {
            Log.i(TAG, "SubSystem5 open");
        }
    }

    class SubSystem6 {
        public void open() {
            Log.i(TAG, "SubSystem6 open");
        }
    }

    interface FacadeInterface{
        void open();
    }

    class FacadeA implements FacadeInterface{

        SubSystem1 subSystem1 = new SubSystem1();
        SubSystem2 subSystem2 = new SubSystem2();
        SubSystem3 subSystem3 = new SubSystem3();

        @Override
        public void open() {
            subSystem1.open();
            subSystem2.open();
            subSystem3.open();
        }
    }

    class FacadeB implements FacadeInterface{

        SubSystem4 subSystem4 = new SubSystem4();
        SubSystem5 subSystem5 = new SubSystem5();
        SubSystem6 subSystem6 = new SubSystem6();

        @Override
        public void open() {
            subSystem4.open();
            subSystem5.open();
            subSystem6.open();
        }
    }

    /**
     * 客户端测试代码
     */
    public void facadePatternExtendTest(){
        FacadeInterface facadeA = new FacadeA();
        facadeA.open();
        FacadeInterface facadeB = new FacadeB();
        facadeB.open();

    }
}
