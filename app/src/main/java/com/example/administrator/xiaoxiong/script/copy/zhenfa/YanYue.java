package com.example.administrator.xiaoxiong.script.copy.zhenfa;

import java.util.Date;

/**
 * 偃月
 * Created by Administrator on 2016/11/12 0012.
 */
public class YanYue extends ZhenFa {


    @Override
    public String inClearLine() {
        return null;
    }

    @Override
    public String saveLine() {
        return null;
    }

    @Override
    public void ready() {
        buyDrug.setName("万年灵芝");
        buyDrug.setNum("300");
       // buyDrug.run();
    }

    @Override
    public boolean fbRun() {
        htmlUtil.linkName("传送到偃月阵");
        htmlUtil.linkName("确定传送");
        if (htmlUtil.getText().contains("今天你已进入")) {
            lastDate = new Date();
            ableIn = false;
            htmlUtil.linkName("返回游戏");
            return false;
        }
        zhandou();
        for (int i=0;i<1000&&!Thread.currentThread().isInterrupted();i++){
            if (htmlUtil.exitsName("偃月中心", true)) {
                break;
            } else if (htmlUtil.exitsName("下:偃月阵↓") && ac != UP) {
                ac = DOWN;
                zhandou2("下:偃月阵↓");
            } else if (htmlUtil.exitsName("左:偃月阵←") && ac != RIGHT) {
                ac = LEFT;
                zhandou2("左:偃月阵←");
            } else if (htmlUtil.exitsName("右:偃月阵→") && ac != LEFT) {
                ac = RIGHT;
                zhandou2("右:偃月阵→");
            } else if (htmlUtil.exitsName("上:偃月阵↑") && ac != DOWN) {
                ac = UP;
                zhandou2("上:偃月阵↑");
            } else {
                if (ac == LEFT) {
                    ac = RIGHT;
                    zhandou2("右:偃月阵→");
                } else if (ac == RIGHT) {
                    ac = LEFT;
                    zhandou2("左:偃月阵←");
                } else if (ac == DOWN) {
                    ac = UP;
                    zhandou2("上:偃月阵↑");
                } else {
                    ac = DOWN;
                    zhandou2("下:偃月阵↓");
                }
            }

        }
        htmlUtil.linkName("偃月中心", true);
        htmlUtil.linkName("偃月将军");
        htmlUtil.linkName("我要挑战");
        zhandou2();
        return true;
    }


}
