package com.example.administrator.xiaoxiong.script.copy;

import java.util.Date;

/**
 * 破碎梦境石
 * Created by Administrator on 2016/11/6 0006.
 */
public class PoSui extends FuBen {

    @Override
    public String inClearLine() {
        return "柳虫,青蛇皮,金创药,蜂王浆,龙皮";
    }

    @Override
    public String outClearLine() {
        return null;
    }

    @Override
    public String saveLine() {
        return "";
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
        htmlUtil.linkName("上东京");
        htmlUtil.linkName("上:北大街↑");
        htmlUtil.linkName("古神兵传说");
        htmlUtil.linkName("入梦(破碎梦晶石x1)");
        if (htmlUtil.getText().contains("今天你已进入")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回游戏");
            return false;
        }
        zhanDou();
        htmlUtil.linkName("下:阴暗↓");
        zhanDou();
        htmlUtil.linkName("右:阴暗→");
        zhanDou();
        htmlUtil.linkName("下:阴暗↓");
        zhanDou();
        htmlUtil.linkName("上:阴暗↑");
        htmlUtil.linkName("右:阴暗→");
        zhanDou();
        htmlUtil.linkName("上:阴暗↑");
        zhanDou();
        htmlUtil.linkName("下:阴暗↓");
        htmlUtil.linkName("右:阴暗→");
        zhanDou();
        htmlUtil.linkName("右:阴暗深处→");
        zhanDou();
        htmlUtil.linkName("梦魇头目");
        htmlUtil.linkName("攻击梦魇头目");
        zhanDou();
        htmlUtil.linkName("进入剑冢");
        htmlUtil.linkName("莫邪");
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("右:心魔之所→");
        htmlUtil.linkName("心魔");
        htmlUtil.linkName("返回心魔");
        htmlUtil.linkName("攻击心魔");
        zhanDou2();
        htmlUtil.linkName("心魔");
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("进入噩梦之所");
        htmlUtil.linkName("噩梦");
        htmlUtil.linkName("攻击噩梦");
        zhanDou2();
        htmlUtil.linkName("左:心魔之所←");
        htmlUtil.linkName("左:剑冢←");
        htmlUtil.linkName("莫邪");
        htmlUtil.linkName("返回游戏");
        return true;
    }


    /**
     * 战斗
     */
    public void zhanDou() {
        htmlUtil.linkName("梦魇小怪");
        htmlUtil.linkName("攻击", true);
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
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 药品战斗
     */
    public void zhanDou2() {
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
        htmlUtil.linkName("返回游戏");
    }

    public void loginIn(){
        htmlUtil.linkName("进入密道");
        htmlUtil.linkName("确定进入");
        while (true){
            if(htmlUtil.exitsName("下:毒虫殿↓")){
                break;
            }else if(htmlUtil.exitsName("下:密道↓")){
                htmlUtil.linkName("下:密道↓");
                zhanDou();
            } else if(htmlUtil.exitsName("右:密道→")){
                htmlUtil.linkName("右:密道→");
                zhanDou();
            }
        }
        htmlUtil.linkName("下:毒虫殿↓");
        htmlUtil.linkName("恶毒蝎子王");
        zhanDou();
        htmlUtil.linkName("巨型青蛙王");
        zhanDou();
        htmlUtil.linkName("奇异毒蛇王");
        zhanDou();
        htmlUtil.linkName("吸血蝙蝠王");
        zhanDou();
        htmlUtil.linkName("进入巫婆殿");
        htmlUtil.linkName("巫婆.叶比亚");
        zhanDou();
    }

}



















