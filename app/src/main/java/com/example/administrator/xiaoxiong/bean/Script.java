package com.example.administrator.xiaoxiong.bean;

import com.example.administrator.xiaoxiong.script.BaseStep;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public class Script {

    private String name;
    private BaseStep baseStep;

    public Script(String name, BaseStep baseStep) {
        this.name = name;
        this.baseStep = baseStep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseStep getBaseStep() {
        return baseStep;
    }

    public void setBaseStep(BaseStep baseStep) {
        this.baseStep = baseStep;
    }
}
