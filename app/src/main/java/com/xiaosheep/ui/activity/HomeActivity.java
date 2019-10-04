package com.xiaosheep.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.designpattern.prototype.DeepClone;
import com.designpattern.prototype.ShallowClone;
import com.xiaosheep.R;

public class HomeActivity extends Activity {

    ShallowClone shallowClone = new ShallowClone();
    DeepClone deepClone = new DeepClone();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        shallowClone.cloen();
        deepClone.deepCloen();
        deepClone.deepCloenSerializable();
    }

}
