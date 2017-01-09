package com.example.administrator.xiaoxiong.script.copy.zhenfa;


import com.example.administrator.xiaoxiong.script.SecondRefresh;

/**
 * Created by Administrator on 2016/11/12 0012.
 */
public abstract class ZhenFa extends SecondRefresh {
    protected static int LEFT = 4;
    protected static int DOWN = 1;
    protected static int RIGHT = 2;
    protected static int UP = 3;
    protected int ac = 0;
    /**
     * 进入副本清理物品字符串
     *
     * @return
     */
    public abstract String inClearLine();


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
        goTo();
        if (!fbRun()) {
            return false;
        }
        goodsSave.setGoods(saveLine());
        goodsSave.run();
        return true;
    }

    public abstract boolean fbRun();

    /**
     * 去阵法大师
     */
    public void goTo() {
        if(!htmlUtil.getText().contains("[沧州广场]")){
            htmlUtil.linkName("功能菜单");
            htmlUtil.linkName("神行千里");
            htmlUtil.linkName("上沧州");
            htmlUtil.linkName("右:街道→");
            htmlUtil.linkName("右:沧州广场→");
        }
        htmlUtil.linkName("阵法大师");
    }

    /**
     * 攻击将军
     */
    public void gjJiangJu() {
//        while (htmlUtil.exitsName("将军部", true)&&htmlUtil.exitsName("万年灵芝",true)) {
//            htmlUtil.linkName("万年灵芝");
//        }
        zhandou();
    }

    /**
     * 战斗
     */
    public void zhandou() {
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("退出副本");
    }

    public void zhandou(String action) {
        htmlUtil.linkName(action);
        zhandou();
    }

    /**
     * 战斗
     */
    public void zhandou2() {
//        while (htmlUtil.exitsName("万年灵芝")) {
//            htmlUtil.linkName("万年灵芝");
//        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("退出副本");
    }

    public void zhandou2(String action) {
        htmlUtil.linkName(action);
        zhandou2();
    }


}
