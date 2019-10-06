package com.designpattern.facade;

import android.util.Log;

/**
 * 外观模式：是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式。
 * 该模式对外有一个统一接口，外部应用程序不用关心内部子系统的具体的细节，这样会大大降低应用程序的复杂度，提高了程序的可维护性。
 * <p>
 * 模式结构：
 * 1。外观（Facade）角色：为多个子系统对外提供一个共同的接口。
 * 2。子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
 * 3。客户（Client）角色：通过一个外观角色访问各个子系统的功能。
 *
 * 缺点：当增加或移除子系统时需要修改外观类，这违背了“开闭原则”。
 * 处理办法：定义一个外观接口，当增加或删减子系统时添加一个具体的外观类。
 *
 */
public class FacadePattern {

    private String TAG = "FacadePattern";

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


    /**
     * 外观类
     */
    class Facade {

        private SubSystem1 subSystem1 = new SubSystem1();
        private SubSystem2 subSystem2 = new SubSystem2();
        private SubSystem3 subSystem3 = new SubSystem3();
        private SubSystem4 subSystem4 = new SubSystem4();
        private SubSystem5 subSystem5 = new SubSystem5();

        public void open() {
            subSystem1.open();
            subSystem2.open();
            subSystem3.open();
            subSystem4.open();
            subSystem5.open();
        }

    }


    /**
     * 客户端测试代码
     */
    public void facadePatternTest() {
        Facade facade = new Facade();
        facade.open();
    }


}
