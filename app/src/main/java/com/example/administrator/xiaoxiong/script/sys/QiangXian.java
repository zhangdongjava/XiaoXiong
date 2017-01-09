package com.example.administrator.xiaoxiong.script.sys;


import com.example.administrator.xiaoxiong.script.BaseStep;

import java.util.Calendar;

/**
 * Created by dell_2 on 2016/11/11.
 */
public class QiangXian extends BaseStep {

    @Override
    public boolean run() {
        Calendar calendar = Calendar.getInstance();
        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        System.out.println("抢仙->>" + h + ":" + min);
        if ((h == 18 && min >= 50)) {
            go();
            while (!htmlUtil.exitsName("VS", true)) {
                htmlUtil.linkName("刷新");
            }
            htmlUtil.linkName("VS", true);
            while (true) {
                if (htmlUtil.exitsName("攻", true)) {
                    htmlUtil.linkName("攻", true);
                } else if (htmlUtil.exitsName("返回", true)) {
                    htmlUtil.linkName("返回", true);
                } else {
                    break;
                }
            }
            if (htmlUtil.exitsName("万年灵芝")) {
                qianDao();
            }
            htmlUtil.linkName("返回游戏", true);
            return true;
        }
        return false;
    }

    public void go() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("上东京");
        htmlUtil.linkName("上:北大街↑");
        htmlUtil.linkName("爬大柱");
        htmlUtil.linkName("紫禁卫士");
        htmlUtil.linkName("攻击紫禁卫士");
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("紫禁卫士");
        htmlUtil.linkName("进入紫禁之巅");
        htmlUtil.linkName("给银两", true);

    }

    public void qianDao() {
        htmlUtil.linkName("攻方", true);
        htmlUtil.linkName("攻方", true);
        htmlUtil.linkName("攻方", true);
        while (htmlUtil.exitsName("万年灵芝")) {
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
        htmlUtil.linkName("x", true);
        htmlUtil.linkName("x", true);
    }
}
