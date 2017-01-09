package com.example.administrator.xiaoxiong.script.copy.normal;

import com.example.administrator.xiaoxiong.script.copy.FuBen;

import java.util.Date;

/**
 * 太尉副本
 * Created by Administrator on 2016/11/6 0006.
 */
public class TaiWei extends FuBen {

    @Override
    public String inClearLine() {
        return "柳虫,青蛇皮,金创药";
    }

    @Override
    public String outClearLine() {
        return "【残阳,黑松果,黑狼";
    }

    @Override
    public String saveLine() {
        return "太尉秘图";
    }


    @Override
    public void ready() {
        buyDrug.setName("万年灵芝");
        buyDrug.setNum("200");
        buyDrug.run();
    }


    @Override
    public boolean fbRun() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("太尉宝库");
        htmlUtil.linkName("进入太尉宝库副本");
        if (htmlUtil.getText().contains("今天你已进入太尉宝库副")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回游戏");
            return false;
        }
        while (htmlUtil.getText().contains("需要使用宝库白银钥匙x1")) {
            htmlUtil.linkName("返回太尉宝库玄铁大门");
            getMenPiao();
        }
        htmlUtil.linkName("宝库铁甲兵");
        htmlUtil.linkName("攻击宝库铁甲兵");
        zhanDou();
        htmlUtil.linkName("进入下.一石阶");
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("宝库精甲兵");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("上:石室↑");
        htmlUtil.linkName("宝库铁甲守将");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("下:石阶↓");
        htmlUtil.linkName("下:石室↓");
        htmlUtil.linkName("宝库精甲守将");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("上:石阶↑");
        htmlUtil.linkName("进入过道");
        htmlUtil.linkName("宝库钢甲兵");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入下.一过道");
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("宝库银甲兵");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("上:铁屋↑");
        htmlUtil.linkName("太尉宝库四将.黄将军");
        htmlUtil.linkName("攻击", true);
        zhanDou();

        htmlUtil.linkName("右:铁屋→");
        htmlUtil.linkName("太尉宝库四将", true);
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("左:铁屋←");
        htmlUtil.linkName("下:过道↓");
        htmlUtil.linkName("下:铁屋↓");
        htmlUtil.linkName("太尉宝库四将", true);
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("右:铁屋→");
        htmlUtil.linkName("太尉宝库四将", true);
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("左:铁屋←");
        htmlUtil.linkName("上:过道↑");
        htmlUtil.linkName("进入秘道");
        htmlUtil.linkName("宝库白银守将");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入下.一秘道");
        htmlUtil.linkName("宝库黄金守将");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入下.一秘道");
        htmlUtil.linkName("下:秘道↓");
        htmlUtil.linkName("左:秘道←");
        htmlUtil.linkName("左:秘道←");
        htmlUtil.linkName("下:秘道↓");
        htmlUtil.linkName("下:秘道↓");
        htmlUtil.linkName("右:秘道→");
        htmlUtil.linkName("下:秘道↓");
        htmlUtil.linkName("右:秘道→");
        htmlUtil.linkName("右:藏宝库巨门→");
        htmlUtil.linkName("宝库守卫大将军.高不低");
        htmlUtil.linkName("攻击", true);
        htmlUtil.linkName("万年灵芝");
        zhanDou();
        htmlUtil.linkName("进入太尉宝库");
        htmlUtil.linkName("宝库守卫元帅.高破风");
        htmlUtil.linkName("攻击", true);
        htmlUtil.linkName("万年灵芝");
        htmlUtil.linkName("万年灵芝");
        zhanDou();
        wjHz();
        return true;
    }


    /**
     * 战斗
     */
    public void zhanDou() {
        for (int i = 0; i < 8; i++) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("太尉", true);
        htmlUtil.linkName("太尉", true);
        htmlUtil.linkName("太尉", true);
        htmlUtil.linkName("魄力", true);
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

    /**
     * 获取门票
     *
     * @return
     */
    public void getMenPiao() {
        htmlUtil.linkName("宝库守卫");
        htmlUtil.linkName("攻击宝库守卫");
        htmlUtil.linkName("万年灵芝");
        htmlUtil.linkName("万年灵芝");
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("钥匙", true);
        htmlUtil.linkName("钥匙", true);
        htmlUtil.linkName("钥匙", true);
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("进入太尉宝库副本");
    }
}



















