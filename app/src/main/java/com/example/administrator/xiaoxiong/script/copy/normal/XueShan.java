package com.example.administrator.xiaoxiong.script.copy.normal;

import com.example.administrator.xiaoxiong.script.copy.FuBen;

import java.util.Date;

/**
 * 雪山副本
 * Created by Administrator on 2016/11/6 0006.
 */
public class XueShan extends FuBen {

    @Override
    public String inClearLine() {
        return "";
    }

    @Override
    public String outClearLine() {
        return "【残阳,黑松果,黑狼";
    }

    @Override
    public String saveLine() {
        return "";
    }


    @Override
    public void ready() {

    }


    @Override
    public boolean fbRun() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("少华山");
        htmlUtil.linkName("少华山石匠");
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("少华山石匠");
        htmlUtil.linkName("传送至落雪山副本");
        if (htmlUtil.getText().contains("今天你已进入")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回游戏");
            return false;
        }
        htmlUtil.linkName("落雪山草寇");
        zhanDou();
        htmlUtil.linkName("进入雪地");
        htmlUtil.linkName("右:雪地→");
        htmlUtil.linkName("右:雪地→");
        htmlUtil.linkName("上:雪地↑");
        htmlUtil.linkName("右:冰河→");
        htmlUtil.linkName("冰河巨鱼");
        zhanDou();
        htmlUtil.linkName("左:雪地←");
        htmlUtil.linkName("下:雪地↓");
        htmlUtil.linkName("左:雪地←");
        htmlUtil.linkName("左:雪地←");
        htmlUtil.linkName("左:雪地←");
        htmlUtil.linkName("上:雪地↑");
        htmlUtil.linkName("左:雪地机关二←");
        htmlUtil.linkName("打开机关");
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("右:雪地→");
        htmlUtil.linkName("下:雪地↓");
        htmlUtil.linkName("右:雪地→");
        htmlUtil.linkName("右:雪地→");
        htmlUtil.linkName("上:白雪地↑");
        htmlUtil.linkName("上:冰原↑");
        htmlUtil.linkName("落雪山小首领");
        zhanDou();
        htmlUtil.linkName("进入雪原");
        htmlUtil.linkName("落雪山首领");
        zhanDou();
        htmlUtil.linkName("进入白雪河");
        htmlUtil.linkName("落雪山七当家");
        zhanDou();
        htmlUtil.linkName("进入寒冰路");
        htmlUtil.linkName("落雪山六当家");
        zhanDou();
        htmlUtil.linkName("进入寒冰坡");
        htmlUtil.linkName("落雪山五当家");
        zhanDou();

        htmlUtil.linkName("进入白雪路");
        htmlUtil.linkName("落雪山四当家");
        zhanDou();
        htmlUtil.linkName("进入落雪山顶");
        htmlUtil.linkName("落雪山三当家");
        zhanDou();
        htmlUtil.linkName("上:落雪洞二↑");
        htmlUtil.linkName("落雪山大当家");
        zhanDou();
        return true;
    }


    /**
     * 战斗
     */
    public void zhanDou() {
        htmlUtil.linkName("攻击", true);
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("冰珠", true);
        htmlUtil.linkName("太尉", true);
        htmlUtil.linkName("太尉", true);
        htmlUtil.linkName("魄力", true);
        htmlUtil.linkName("返回游戏");
    }

}



















