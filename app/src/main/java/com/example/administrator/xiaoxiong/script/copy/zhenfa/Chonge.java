package com.example.administrator.xiaoxiong.script.copy.zhenfa;

import java.util.Date;

/**
 * 冲轭阵
 * Created by Administrator on 2016/11/12 0012.
 */
public class Chonge extends ZhenFa {



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
        htmlUtil.linkName("传送到冲轭阵");
        htmlUtil.linkName("确定传送");
        if(htmlUtil.getText().contains("今天你已进入")){
            lastDate = new Date();
            ableIn = false;
            htmlUtil.linkName("返回游戏");
            return false;
        }
        zhandou();
        for (int i=0;i<1000&&!Thread.currentThread().isInterrupted();i++){
            if (htmlUtil.exitsName("冲轭中心", true)) {
                break;
            } else if (htmlUtil.exitsName("下:冲轭阵↓")) {
                zhandou("下:冲轭阵↓");
            } else if (htmlUtil.exitsName("左:冲轭阵←")&&ac!=RIGHT) {
                ac = LEFT;
                zhandou("左:冲轭阵←");
            } else if(htmlUtil.exitsName("右:冲轭阵→")&&ac!=LEFT) {
                ac = RIGHT;
                zhandou("右:冲轭阵→");
            }else {
                if(ac ==LEFT){
                    ac = RIGHT;
                    zhandou("右:冲轭阵→");
                }else if(ac == RIGHT){
                    ac = LEFT;
                    zhandou("左:冲轭阵←");
                }else if(ac == DOWN){
                    ac = UP;
                    zhandou("上:冲轭阵↑");
                }else{
                    ac = DOWN;
                    zhandou("下:冲轭阵↓");
                }
            }
        }
        htmlUtil.linkName("冲轭中心", true);
        htmlUtil.linkName("冲轭将军");
        htmlUtil.linkName("我要挑战");
        gjJiangJu();
        return true;
    }




}
