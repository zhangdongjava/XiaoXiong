package com.example.administrator.xiaoxiong.script;

import com.example.administrator.xiaoxiong.util.HtmlUtil;

/**
 * Created by dell_2 on 2016/10/29.
 */
public class BaseStep {

    protected HtmlUtil htmlUtil;

    public boolean run() {
        return false;
    }

    public void setHtmlUtil(HtmlUtil htmlContent) {
        this.htmlUtil = htmlContent;
    }


}
