package com.example.administrator.xiaoxiong.script.yinzi;

import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.script.BaseStep;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public class MangShe extends BaseStep {

    @Override
    public boolean run() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("去沂岭");
        htmlUtil.linkName("上:山路↑");
        htmlUtil.linkName("上:崎岖小路↑");
        htmlUtil.linkName("上:半山腰↑");
        htmlUtil.linkName("上:险峻山路↑");
        htmlUtil.linkName("上:沂岭顶↑");
        htmlUtil.linkName("右:峡谷→");
       go("右:绿竹林→");
       go("右:绿竹林→");
       go("上:绿竹林↑");
       go("右:绿竹林→");
       go("上:绿竹林↑");
       go("下:绿竹林↓");
       go("左:绿竹林←");
       go("下:绿竹林↓");
       go("右:绿竹林→");
       go("左:绿竹林←");
       go("下:绿竹林↓");
       go("右:绿竹林→");
       go("左:绿竹林←");
       go("下:绿竹林↓");
       go("右:绿竹林→");
        return true;
    }

    
    private void go(String action){
        htmlUtil.linkName(action);
        mangse();
    }
    
    private void fight(){
        htmlUtil.linkName("攻击",true);
        while (htmlUtil.exitsName("普通攻击")){
            htmlUtil.linkName("普通攻击");
        }
        htmlUtil.linkName("返回游戏");
    }

    private void mangse(){
        gj("蟒蛇");
        gj("蟒蛇");
        gj("蟒蛇");
        gj("大蟒蛇");
        gj("大蟒蛇");
    }
    private void gj(String name){
        LinkBean res = htmlUtil.linkName(name);
        if(res.isSuccess()){
            fight();
        }
    }
}
