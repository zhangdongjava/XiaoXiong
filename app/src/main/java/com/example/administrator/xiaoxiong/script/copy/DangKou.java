package com.example.administrator.xiaoxiong.script.copy;

import java.util.Date;

/**
 * 荡寇
 * Created by Administrator on 2016/11/6 0006.
 */
public class DangKou extends FuBen {

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

    }


    @Override
    public boolean fbRun() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("物品");
        htmlUtil.linkName("其它");
        htmlUtil.linkName("上页");
        htmlUtil.linkName("首页");
        while (!htmlUtil.exitsName("御赐讨伐令箭",true)){
            htmlUtil.linkName("下.页");
        }
        htmlUtil.linkName("御赐讨伐令箭",true);
        htmlUtil.linkName("荡寇");
        if (htmlUtil.getText().contains("今天你已进入")) {
            ableIn = false;
            lastDate = new Date();
            htmlUtil.linkName("返回游戏");
            return false;
        }
        htmlUtil.linkName("下:草原↓");
        htmlUtil.linkName("下:草原↓");
        htmlUtil.linkName("右:草原→");
        htmlUtil.linkName("下:绿洲↓");
        htmlUtil.linkName("下:绿洲↓");
        htmlUtil.linkName("右:红帐篷→");
        htmlUtil.linkName("波斯人入侵者");
        zhanDou();
        htmlUtil.linkName("波斯人入侵者");
        zhanDou();
        htmlUtil.linkName("波斯人入侵者");
        zhanDou();
        if(htmlUtil.exitsName("进入密道")){
            loginIn();
            return true;
        }
        htmlUtil.linkName("左:绿洲←");
        htmlUtil.linkName("左:绿洲←");
        htmlUtil.linkName("左:绿洲←");
        htmlUtil.linkName("下:黑帐篷↓");
        htmlUtil.linkName("叛乱喇嘛");
        zhanDou();
        htmlUtil.linkName("叛乱喇嘛");
        zhanDou();
        htmlUtil.linkName("叛乱喇嘛");
        zhanDou();
        if(htmlUtil.exitsName("进入密道")){
            loginIn();
            return true;
        }

        htmlUtil.linkName("上:绿洲↑");
        htmlUtil.linkName("左:草原←");
        htmlUtil.linkName("下:草原↓");
        htmlUtil.linkName("下:红黑帐篷↓");
        htmlUtil.linkName("波斯人入侵者头领");
        zhanDou();
        htmlUtil.linkName("叛乱喇嘛头子");
        zhanDou();
        loginIn();
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
        for (int i=0;i<1000&&!Thread.currentThread().isInterrupted();i++){
            if(htmlUtil.exitsName("下:毒虫殿↓")){
                break;
            }else if(htmlUtil.exitsName("下:密道↓")){
                htmlUtil.linkName("下:密道↓");
            } else if(htmlUtil.exitsName("右:密道→")){
                htmlUtil.linkName("右:密道→");
            }
            zhanDou();
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



















