package com.example.administrator.xiaoxiong.script.copy;


import com.example.administrator.xiaoxiong.script.BaseStep;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.ChangShe;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.CheXuan;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.Chonge;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.FengShi;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.HeYi;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.YanXing;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.YanYue;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.YuLin;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.ZhenFa;
import com.example.administrator.xiaoxiong.script.copy.zhenfa.fangYuan;
import com.example.administrator.xiaoxiong.util.HtmlUtil;

import java.util.LinkedList;

/**
 * 刷阵
 * Created by Administrator on 2016/11/12 0012.
 */
public class ZhenList extends BaseStep {
    LinkedList<ZhenFa> zhenFas = new LinkedList<>();

    @Override
    public void setHtmlUtil(HtmlUtil htmlContent) {
        super.setHtmlUtil(htmlContent);
        for (ZhenFa zhenFa : zhenFas) {
            zhenFa.setHtmlUtil(htmlContent);
        }
    }

    public ZhenList() {
        zhenFas.add(new HeYi());
        zhenFas.add(new YuLin());
        zhenFas.add(new ChangShe());
        zhenFas.add(new CheXuan());
        zhenFas.add(new Chonge());
        zhenFas.add(new fangYuan());
        zhenFas.add(new FengShi());
        zhenFas.add(new YanXing());
        zhenFas.add(new YanYue());
    }

    @Override
    public boolean run() {
        for (ZhenFa zhenFa : zhenFas) {
            zhenFa.run();
        }
        return true;
    }
}
