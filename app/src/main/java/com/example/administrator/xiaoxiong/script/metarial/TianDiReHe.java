package com.example.administrator.xiaoxiong.script.metarial;

import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.script.BaseStep;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class TianDiReHe extends BaseStep {
    @Override
    public boolean run() {
        htmlUtil.linkName("返回游戏");
        if(!htmlUtil.getText().contains("人兵阵")){
            htmlUtil.linkName("功能菜单");
            htmlUtil.linkName("神行千里");
            htmlUtil.linkName("景阳岗");
            htmlUtil.linkName("下:官道↓");
            htmlUtil.linkName("左:官道←");
            htmlUtil.linkName("左:官道←");
            htmlUtil.linkName("左:岔口←");
            htmlUtil.linkName("左:官道←");
            htmlUtil.linkName("上:官道↑");
            htmlUtil.linkName("兵阵使者");
            htmlUtil.linkName("人兵阵",true);
        }
        htmlUtil.linkName("返回游戏");
        while (htmlUtil.controller.run) {
            htmlUtil.linkName("主C");
            htmlUtil.linkName("五彩神牛");
            htmlUtil.linkName("装备");
            htmlUtil.linkName("修理所有");
            htmlUtil.linkName("返回仙兵");
            htmlUtil.linkName("装备");
            htmlUtil.linkName("修理所有");
            htmlUtil.linkName("返回游戏");
            shua();
        }
        return true;
    }

    public void shua() {
        goFight("上:人兵阵(1,2)↑");
        goFight("上:人兵阵(1,3)↑");
        goFight("上:人兵阵(1,4)↑");
        goFight("上:人兵阵(1,5)↑");
        goFight("上:人兵阵(1,6)↑");
        goFight("右:人兵阵(2,6)→");
        goFight("下:人兵阵(2,5)↓");
        goFight("下:人兵阵(2,4)↓");
        goFight("下:人兵阵(2,3)↓");
        goFight("下:人兵阵(2,2)↓");
        goFight("下:人兵阵(2,1)↓");
        goFight("右:人兵阵(3,1)→");
        goFight("上:人兵阵(3,2)↑");
        goFight("上:人兵阵(3,3)↑");
        goFight("上:人兵阵(3,4)↑");
        goFight("上:人兵阵(3,5)↑");
        goFight("上:人兵阵(3,6)↑");
        goFight("右:人兵阵(4,6)→");
        goFight("下:人兵阵(4,5)↓");
        goFight("右:人兵阵(5,5)→");
        goFight("下:人兵阵(5,4)↓");
        goFight("左:人兵阵(4,4)←");
        goFight("下:人兵阵(4,3)↓");
        goFight("下:人兵阵(4,2)↓");
        goFight("下:人兵阵(4,1)↓");
        goFight("右:人兵阵(5,1)→");
        goFight("上:人兵阵(5,2)↑");
        goFight("上:人兵阵(5,3)↑");
        goFight("上:人兵阵(5,4)↑");
        goFight("上:人兵阵(5,5)↑");
        goFight("上:人兵阵(5,6)↑");
        goFight("右:人兵阵(6,6)→");
        goFight("下:人兵阵(6,5)↓");
        goFight("下:人兵阵(6,4)↓");
        goFight("下:人兵阵(6,3)↓");
        goFight("下:人兵阵(6,2)↓");
        goFight("下:人兵阵(6,1)↓");
        goFight("左:人兵阵(5,1)←");
        goFight("左:人兵阵(4,1)←");
        goFight("左:人兵阵(3,1)←");
        goFight("左:人兵阵(2,1)←");
        goFight("左:人兵阵(1,1)←");
    }

    public void goFight(String action) {
        guai();
        guai();
        guai();
        htmlUtil.linkName(action);
    }

    private void guai() {
        LinkBean res = htmlUtil.linkName("大人兵");
        if (!res.isSuccess()) {
            res = htmlUtil.linkName("小人兵");
        }
        if (!res.isSuccess()) {
            return;
        }
        fight();
        htmlUtil.linkName("武将");
        htmlUtil.linkName("供给粮草");
        htmlUtil.linkName("供给粮草");
        htmlUtil.linkName("返回游戏");
    }

    private void fight() {
        while (htmlUtil.linkName("普通攻击").isSuccess()) ;
        htmlUtil.linkName("替天行道", true);
        htmlUtil.linkName("替天行道", true);
        htmlUtil.linkName("替天行道", true);
        htmlUtil.linkName("替天行道", true);
        htmlUtil.linkName("替天行道", true);
        while (htmlUtil.linkName("x",true).isSuccess()) ;
        htmlUtil.linkName("返回游戏");
    }
}
