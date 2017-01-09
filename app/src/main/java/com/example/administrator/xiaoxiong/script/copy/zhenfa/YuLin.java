package com.example.administrator.xiaoxiong.script.copy.zhenfa;

import java.util.Date;

/**
 * 鱼鳞
 * Created by Administrator on 2016/11/12 0012.
 */
public class YuLin extends ZhenFa {
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
        htmlUtil.linkName("传送到鱼鳞阵");
        htmlUtil.linkName("确定传送");
        if(htmlUtil.getText().contains("今天你已进入")){
            lastDate = new Date();
            ableIn = false;
            htmlUtil.linkName("返回游戏");
            return false;
        }
        zhandou();
        for (int i=0;i<1000&&!Thread.currentThread().isInterrupted();i++){
            if (htmlUtil.exitsName("鱼鳞中心", true)) {
                break;
            } else if (htmlUtil.exitsName("下:鱼鳞阵↓")) {
                zhandou("下:鱼鳞阵↓");
            } else if (htmlUtil.exitsName("左:鱼鳞阵←")&&ac!=RIGHT) {
                ac = LEFT;
                zhandou("左:鱼鳞阵←");
            } else if(htmlUtil.exitsName("右:鱼鳞阵→")&&ac!=LEFT) {
                ac = RIGHT;
                zhandou("右:鱼鳞阵→");
            }else {
                if(ac ==LEFT){
                    ac = RIGHT;
                    zhandou("右:鱼鳞阵→");
                }else if(ac == RIGHT){
                    ac = LEFT;
                    zhandou("左:鱼鳞阵←");
                }else if(ac == DOWN){
                    ac = UP;
                    zhandou("上:鱼鳞阵↑");
                }else{
                    ac = DOWN;
                    zhandou("下:鱼鳞阵↓");
                }
            }
        }
        htmlUtil.linkName("鱼鳞中心", true);
        htmlUtil.linkName("鱼鳞将军");
        htmlUtil.linkName("我要挑战");
        gjJiangJu();
        return true;
    }




}
