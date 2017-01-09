package com.example.administrator.xiaoxiong.script.sys;


import com.example.administrator.xiaoxiong.script.BaseStep;
import com.example.administrator.xiaoxiong.util.HtmlUtil;

/**
 * 结束战斗 解决战斗中问题
 * Created by dell_2 on 2016/11/2.
 */
public class FinishCombat extends BaseStep {

    public FinishCombat(HtmlUtil htmlContent) {
        this.htmlUtil = htmlContent;
    }

    @Override
    public boolean run() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("战场");
        htmlUtil.linkName("VS", true);
        while (htmlUtil.exitsName("普通攻击")) {
            htmlUtil.linkName("普通攻击");
        }
        while (htmlUtil.exitsName("x", true)) {
            htmlUtil.linkName("x", true);
        }
        htmlUtil.linkName("返回游戏");
        return true;
    }
}
