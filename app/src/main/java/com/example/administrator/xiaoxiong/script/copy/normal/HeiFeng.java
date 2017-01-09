package com.example.administrator.xiaoxiong.script.copy.normal;

import com.example.administrator.xiaoxiong.script.copy.FuBen;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
public class HeiFeng extends FuBen {

    @Override
    public String inClearLine() {
        return "柳虫,青蛇皮,金创药";
    }

    @Override
    public String outClearLine() {
        return "【追风,黑松果,黑狼";
    }

    @Override
    public String saveLine() {
        return "强体奇书";
    }

    private int i = 0;


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
        htmlUtil.linkName("黑风岭");
        htmlUtil.linkName("黑风岭砍柴老者");
        htmlUtil.linkName("进入黑风岭副本");
        if (htmlUtil.getText().contains("今天你已进入黑风岭副本")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回游戏");
            return false;
        }
        gjHml();
        htmlUtil.linkName("右:黑松林→");
        gjHml();
        htmlUtil.linkName("右:黑松林→");
        gjHml();
        htmlUtil.linkName("右:黑松林→");
        gjHml();
        htmlUtil.linkName("右:乱石河边→");
        htmlUtil.linkName("进入乱石河");
        i = 0;
        while (htmlUtil.getText().contains("从乱石河边->乱石河需要黑松果x5")) {
            getCl();
            if (i > 5) {
                htmlUtil.linkName("返回乱石河边");
                htmlUtil.linkName("返回游戏");
                htmlUtil.linkName("队伍");
                htmlUtil.linkName("退出队伍");
                htmlUtil.linkName("确定退出");
                htmlUtil.linkName("返回游戏");
                return false;
            }
        }
        htmlUtil.linkName("巨型鲤鱼");
        htmlUtil.linkName("攻击巨型鲤鱼");
        zhanDou();
        htmlUtil.linkName("进入猛虎坡");
        htmlUtil.linkName("病大虫");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入猛虎洞");
        htmlUtil.linkName("黑风虎");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入洞穴");
        for (int i = 0; i < 3; i++) {
            htmlUtil.linkName("黑风雌虎");
            htmlUtil.linkName("攻击", true);
            zhanDou();
        }
        htmlUtil.linkName("进入窄路");
        htmlUtil.linkName("黑风雄虎");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("进入潮湿小路");
        htmlUtil.linkName("左:内洞←");
        htmlUtil.linkName("巨型猛虎");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        htmlUtil.linkName("右:潮湿小路→");
        htmlUtil.linkName("进入巨型洞穴");
        htmlUtil.linkName("虎王");
        htmlUtil.linkName("攻击", true);
        zhanDou();
        wjHz();
        return true;
    }

    public void gjHml() {
        htmlUtil.linkName("黑松果", true);
        htmlUtil.linkName("黑毛狼");
        htmlUtil.linkName("攻击黑毛狼");
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("黑狼毛", true);
        htmlUtil.linkName("返回游戏");
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
        htmlUtil.linkName("虎骨", true);
        htmlUtil.linkName("虎骨", true);
        htmlUtil.linkName("虎骨", true);
        htmlUtil.linkName("魄力", true);
        htmlUtil.linkName("返回游戏");
    }

    /**
     * 获取进去材料
     */
    public void getCl() {
        i++;
        htmlUtil.linkName("返回乱石河边");
        htmlUtil.linkName("左:黑松林←");
        gjHml();
        htmlUtil.linkName("下:黑松林↓");
        gjHml();
        htmlUtil.linkName("上:黑松林↑");
        gjHml();
        htmlUtil.linkName("左:黑松林←");
        gjHml();
        htmlUtil.linkName("上:黑松林↑");
        gjHml();
        htmlUtil.linkName("下:黑松林↓");
        gjHml();
        htmlUtil.linkName("左:黑松林←");
        gjHml();
        htmlUtil.linkName("左:黑松林←");
        gjHml();
        for (int i = 0; i < 5; i++) {
            htmlUtil.linkName("右:黑松林→");
        }
        htmlUtil.linkName("右:乱石河边→");
        htmlUtil.linkName("进入乱石河");
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



















