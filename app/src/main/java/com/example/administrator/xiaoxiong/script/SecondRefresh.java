package com.example.administrator.xiaoxiong.script;



import com.example.administrator.xiaoxiong.script.sys.BuyDrug;
import com.example.administrator.xiaoxiong.script.sys.GoodsSale2;
import com.example.administrator.xiaoxiong.script.sys.GoodsSave2;
import com.example.administrator.xiaoxiong.script.sys.GoodsTakeout;
import com.example.administrator.xiaoxiong.util.HtmlUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * 超类
 * Created by dell_2 on 2016/11/10.
 */
public abstract class SecondRefresh extends BaseStep {

    protected BuyDrug buyDrug = new BuyDrug();
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();

    protected GoodsSale2 goodsSale2 = new GoodsSale2();
    protected GoodsSave2 goodsSave = new GoodsSave2();
    protected GoodsTakeout goodsTakeout =new GoodsTakeout();

    @Override
    public void setHtmlUtil(HtmlUtil htmlContent) {
        super.setHtmlUtil(htmlContent);
        buyDrug.setHtmlUtil(htmlContent);
        goodsSale2.setHtmlUtil(htmlContent);
        goodsSave.setHtmlUtil(htmlContent);
        goodsTakeout.setHtmlUtil(htmlContent);
    }


    /**
     * 是否可以运行
     */
    protected boolean ableIn = true;

    /**
     * 结束运行时时间 过了这天就刷新
     */
    protected Date lastDate;


    protected void fresh() {
        if (lastDate == null) {
            return;
        }

        c1.setTime(lastDate);
        c2.setTime(new Date());
        if (c1.get(Calendar.DAY_OF_MONTH) != c2.get(Calendar.DAY_OF_MONTH)) {
            ableIn = true;
        }
    }
}
