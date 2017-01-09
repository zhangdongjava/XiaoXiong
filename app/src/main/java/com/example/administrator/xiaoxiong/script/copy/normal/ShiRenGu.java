package com.example.administrator.xiaoxiong.script.copy.normal;

import com.example.administrator.xiaoxiong.script.copy.FuBen;

import java.util.Date;

/**
 * 食人谷
 * Created by Administrator on 2016/11/6 0006.
 */
public class ShiRenGu extends FuBen {

    @Override
    public String inClearLine() {
        return "柳虫,青蛇皮,金创药";
    }

    @Override
    public String outClearLine() {
        return "【玉清,黑松果,黑狼";
    }

    @Override
    public String saveLine() {
        return "狂暴一";
    }


    @Override
    public void ready() {
        buyDrug.setName("万年灵芝");
        buyDrug.setNum("100");
        buyDrug.run();
    }


    @Override
    public boolean fbRun() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("食人谷");
        htmlUtil.linkName("进入食人谷副本");
        if (htmlUtil.getText().contains("今天你已进入食人谷副本")) {
            ableIn = false;
            lastDate = new Date();
            return false;
        }
        while (htmlUtil.getText().contains("进入食人谷副本，必须攀下一个悬崖")) {
            htmlUtil.linkName("返回食人谷悬崖");
            gjSj();
        }
        htmlUtil.linkName("守谷小喽罗");
        htmlUtil.linkName("攻击守谷小喽罗");
        zhanDou();
        htmlUtil.linkName("进入悬崖大树");
        htmlUtil.linkName("大吼猴");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("下:食人谷口↓");
        htmlUtil.linkName("进入一线天");
        htmlUtil.linkName("剧毒奇寒蛇");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入狭小石门");
        for (int i = 0; i < 3; i++) {
            htmlUtil.linkName("食人谷守卫");
            htmlUtil.linkName("攻击", true);
            zhanDou();
        }
        htmlUtil.linkName("进入小河边");
        htmlUtil.linkName("食人谷力士");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入河底");
        htmlUtil.linkName("食人怪鱼");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("左:小河边←");
        htmlUtil.linkName("上:小路↑");
        htmlUtil.linkName("右:巨型峡谷→");
        htmlUtil.linkName("食人谷护法");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("上:奇异果园↑");
        htmlUtil.linkName("食人谷果农");
        htmlUtil.linkName("配置狂暴一");
        htmlUtil.linkName("返回", true);
        htmlUtil.linkName("配置狂暴一");
        htmlUtil.linkName("返回", true);
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("下:巨型峡谷↓");
        htmlUtil.linkName("进入谷内小屋");
        htmlUtil.linkName("食人谷五当家");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("右:大堂→");
        htmlUtil.linkName("食人谷四当家");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("上:北偏厅↑");
        htmlUtil.linkName("食人谷三当家");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("下:大堂↓");
        htmlUtil.linkName("下:南偏厅↓");
        htmlUtil.linkName("食人谷二当家");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("上:大堂↑");
        htmlUtil.linkName("进入暗室");
        htmlUtil.linkName("食人谷大当家");
        htmlUtil.linkName("攻击", true);
        htmlUtil.linkName("万年灵芝");
        htmlUtil.linkName("万年灵芝");
        htmlUtil.linkName("万年灵芝");
        zhanDou();
        wjHz();
        return true;
    }

    /**
     * 获取蛇筋
     */
    public void gjSj() {
        for (int i = 0; i < 5; i++) {
            htmlUtil.linkName("巨蛇");
            htmlUtil.linkName("攻击巨蛇");
            htmlUtil.linkName("万年灵芝");
            while (htmlUtil.exitsName("普通攻击")) {
                htmlUtil.linkName("普通攻击");
            }
            htmlUtil.linkName("蛇筋", true);
            htmlUtil.linkName("返回游戏");
        }
        htmlUtil.linkName("进入食人谷副本");
    }

    /**
     * 战斗
     */
    public void zhanDou() {
        for (int i = 0; i < 5; i++) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 武将换装
     */
    public void wjHz() {
        htmlUtil.linkName("武将");
        htmlUtil.linkName("周武师", true);
        htmlUtil.linkName("装备");
        htmlUtil.linkName("自动换装");
        htmlUtil.linkName("返回游戏");
    }
}



















