package com.example.administrator.xiaoxiong.script.copy.normal;

import com.example.administrator.xiaoxiong.script.copy.FuBen;

import java.util.Date;

/**
 * 冰魄洞
 * Created by Administrator on 2016/11/6 0006.
 */
public class BingPoDong extends FuBen {

    @Override
    public String inClearLine() {
        return "柳虫,青蛇皮,金创药";
    }

    @Override
    public String outClearLine() {
        return "【神行,黑松果,黑狼";
    }

    @Override
    public String saveLine() {
        return "冰魄珠";
    }


    @Override
    public void ready() {
        buyDrug.setName("万年灵芝");
        buyDrug.setNum("300");
        buyDrug.run();
    }


    @Override
    public boolean fbRun() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("冰魄洞");
        htmlUtil.linkName("下:枯木↓");
        htmlUtil.linkName("红角兽王");
        htmlUtil.linkName("攻击红角兽王");
        zhanDou();
        htmlUtil.linkName("上:冰魄洞口↑");
        htmlUtil.linkName("冰封老人");
        htmlUtil.linkName("进入冰魄洞副本");
        htmlUtil.linkName("传送进冰魄洞");
        if (htmlUtil.getText().contains("今天你已进入")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回",true);
            htmlUtil.linkName("返回",true);
            htmlUtil.linkName("返回游戏");
            return false;
        }
        if (htmlUtil.getText().contains("对不起，需要提供红角兽王鬃毛x1")) {
            return false;
        }
        htmlUtil.linkName("返回游戏");
        sd();
        sd("上:水洞↑");
        sd("右:水洞→");
        sd("下:水洞↓");
        sd("下:水洞↓");
        sd("左:水洞←");
        sd("上:水洞↑");
        sd("右:水洞→");
        sd("右:水洞→");
        htmlUtil.linkName("水洞守卫");
        zhanDou(8);
        htmlUtil.linkName("水灵怪兽");
        zhanDou(8);
        htmlUtil.linkName("进入木洞");
        htmlUtil.linkName("返回游戏");
        md();
        md("上:木洞↑");
        md("上:木洞↑");
        md("右:木洞→");
        md("下:木洞↓");
        md("下:木洞↓");
        md("下:木洞↓");
        md("下:木洞↓");
        md("左:木洞←");
        md("上:木洞↑");
        md("上:木洞↑");
        md("右:木洞→");
        md("右:木洞→");
        htmlUtil.linkName("木洞守卫");
        zhanDou(8);
        htmlUtil.linkName("木灵怪兽");
        zhanDou(8);
        htmlUtil.linkName("进入冰洞");
        htmlUtil.linkName("返回游戏");
        bd();
        bd("上:冰洞↑");
        bd("上:冰洞↑");
        bd("右:冰洞→");
        bd("右:冰洞→");
        bd("下:冰洞↓");
        bd("左:冰洞←");
        bd("左:冰洞←");
        bd("下:冰洞↓");
        bd("右:冰洞→");
        bd("右:冰洞→");
        bd("下:冰洞↓");
        bd("左:冰洞←");
        bd("左:冰洞←");
        bd("下:冰洞↓");
        bd("右:冰洞→");
        bd("右:冰洞→");
        bd("上:冰洞↑");
        bd("上:冰洞↑");
        bd("右:冰洞→");
        htmlUtil.linkName("冰洞守卫");
        zhanDou(8);
        htmlUtil.linkName("冰灵怪兽");
        zhanDou(8);
        htmlUtil.linkName("进入黑金桥");
        htmlUtil.linkName("黑金使者");
        zhanDouShizhe();
        htmlUtil.linkName("进入紫土桥");
        htmlUtil.linkName("紫土使者");
        zhanDouShizhe();
        htmlUtil.linkName("进入铁木桥");
        htmlUtil.linkName("铁木使者");
        zhanDouShizhe();
        htmlUtil.linkName("进入寒水桥");
        htmlUtil.linkName("寒水使者");
        zhanDouShizhe();
        htmlUtil.linkName("进入烈焰桥");
        htmlUtil.linkName("烈焰使者");
        zhanDouShizhe();
        htmlUtil.linkName("进入冰魄洞");
        htmlUtil.linkName("天怒神兽");
        zhanDou(15);
        htmlUtil.linkName("冰魄异兽");
        zhanDouShizhe();
        wjHz();
        return true;
    }


    /**
     * 战斗
     */
    public void zhanDou(int size) {
        htmlUtil.linkName("攻击", true);
        for (int i = 0; i < size; i++) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("红角兽王鬃毛", true);
        htmlUtil.linkName("冰魄珠", true);
        htmlUtil.linkName("禁军", true);
        htmlUtil.linkName("御林", true);
        htmlUtil.linkName("魄力", true);
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 战斗
     */
    public void zhanDouShizhe() {
        htmlUtil.linkName("攻击", true);
        while ((!htmlUtil.getText().contains("冰洞守卫(0)"))
                && htmlUtil.exitsName("万年灵芝")) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("红角兽王鬃毛", true);
        htmlUtil.linkName("冰魄珠", true);
        htmlUtil.linkName("禁军", true);
        htmlUtil.linkName("御林", true);
        htmlUtil.linkName("魄力", true);
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 战斗
     */
    public void zhanDou() {
        zhanDou(8);
    }

    /**
     * 攻击水洞守卫
     */
    public void sd(String name) {
        htmlUtil.linkName(name);
        sd();
    }

    /**
     * 攻击水洞守卫
     */
    public void sd() {
        htmlUtil.linkName("水洞守卫");
        htmlUtil.linkName("攻击水洞守卫");
        while ((!htmlUtil.getText().contains("步兵(0)"))
                && htmlUtil.exitsName("万年灵芝")) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("御林", true);
        htmlUtil.linkName("禁军", true);
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 攻击木洞守卫
     */
    public void md(String name) {
        htmlUtil.linkName(name);
        md();
    }

    /**
     * 攻击木洞守卫
     */
    public void md() {
        htmlUtil.linkName("木洞守卫");
        htmlUtil.linkName("攻击木洞守卫");
        while ((!htmlUtil.getText().contains("步兵(0)"))
                && htmlUtil.exitsName("万年灵芝")) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("御林", true);
        htmlUtil.linkName("禁军", true);
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 攻击冰洞守卫
     */
    public void bd(String name) {
        htmlUtil.linkName(name);
        bd();
    }

    /**
     * 攻击冰洞守卫
     */
    public void bd() {
        htmlUtil.linkName("冰洞守卫");
        htmlUtil.linkName("攻击冰洞守卫");
        while ((!htmlUtil.getText().contains("步兵(0)"))
                && htmlUtil.exitsName("万年灵芝")) {
            htmlUtil.linkName("万年灵芝");
        }
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("御林", true);
        htmlUtil.linkName("禁军", true);
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



















