package com.example.administrator.xiaoxiong.script.sys;


import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.script.BaseStep;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
public class BuyDrug extends BaseStep {

    private String name;
    /**
     * 共需要多少个
     */
    private String num;
    /**
     * 要购买的个数 = num - 现有的
     */
    private String buyNum;
    /**
     * 当前背包数量
     */
    private int currNum;

    FormSubmit formSubmit;

    public BuyDrug() {
        formSubmit = new FormSubmit();
    }

    public BuyDrug(String line) {
        String[] lines = line.split("_");
        name = lines[0];
        num = lines[1];
        formSubmit = new FormSubmit();
        formSubmit.setValue(num);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        formSubmit.setValue(num);
        this.num = num;
    }

    @Override
    public boolean run() {
        if (!cleck()) {
            return false;
        }
        formSubmit.setHtmlUtil(htmlUtil);
        formSubmit.setValue(buyNum);
        htmlUtil.linkName("功能菜单");
        htmlUtil.linkName("神行千里");
        htmlUtil.linkName("上东京");
        htmlUtil.linkName("上:北大街↑");
        htmlUtil.linkName("右:妙手药铺→");
        htmlUtil.linkName("妙手回春");
        htmlUtil.linkName("购买物品");
        htmlUtil.linkName(name, true);
        formSubmit.run();
        htmlUtil.linkName("返回游戏");
        return true;
    }

    /**
     * 检测要品数量来判断买多少个
     * 不要购买返回false
     */
    private boolean cleck() {
        currNum = 0;
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("物品");
        htmlUtil.linkName("消耗品");
        htmlUtil.linkName("首页");
        htmlUtil.linkName("上页");
        do {
            if (checkPage())
                break;
        } while (htmlUtil.linkName("下.页").isSuccess());
        htmlUtil.linkName("返回游戏");
        int buy = Integer.valueOf(num) - currNum;
        buyNum = String.valueOf(buy);
        return buy > 0;
    }

    /**
     * 卖出当页物品
     */
    public boolean checkPage() {
        ExistSale existSale = existSale();
        if (existSale.exist) {
            String name = existSale.name;
            cleckOne(name);
        }
        return existSale.exist;
    }

    public void cleckOne(String name) {
        LinkBean res = htmlUtil.linkName(name, true);
        name = res.getClickName();
        if (name.contains("x")) {
            currNum = Integer.valueOf(name.substring(name.indexOf("x") + 1).trim());
        } else {
            currNum = 1;
        }
    }


    /**
     * 检测是否有商品存在
     *
     * @return
     */
    public ExistSale existSale() {
        ExistSale existSale = new ExistSale();
        if (htmlUtil.exitsName(name, true)) {
            existSale.exist = true;
            existSale.name = name;
            return existSale;
        }
        return existSale;
    }

    private class ExistSale {
        public boolean exist = false;
        public String name = null;
    }
}













































