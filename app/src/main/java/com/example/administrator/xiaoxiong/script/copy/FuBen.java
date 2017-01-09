package com.example.administrator.xiaoxiong.script.copy;


import com.example.administrator.xiaoxiong.script.SecondRefresh;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
public abstract class FuBen extends SecondRefresh {

    /**
     * 进入副本清理物品字符串
     *
     * @return
     */
    public abstract String inClearLine();

    /**
     * 推出副本清理物品字符串
     *
     * @return
     */
    public abstract String outClearLine();

    /**
     * 要保存的物品
     *
     * @return
     */
    public abstract String saveLine();


    /**
     * 准备东西
     *
     * @return
     */
    public abstract void ready();

    @Override
    public boolean run() {
        fresh();
        if (!ableIn) {
            return false;
        }
        goodsSale2.setGoods(inClearLine());
        goodsSale2.run();
        ready();
        if (!fbRun()) {
            return false;
        }
        goodsSave.setGoods(saveLine());
        goodsSave.run();
        goodsSale2.clear();
        goodsSale2.setGoods(outClearLine());
        goodsSale2.run();
        return true;
    }

    public abstract boolean fbRun();


}
































