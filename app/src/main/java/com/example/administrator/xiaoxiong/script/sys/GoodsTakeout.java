package com.example.administrator.xiaoxiong.script.sys;

import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.script.BaseStep;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 仓库取出物品
 * Created by dell_2 on 2016/10/31.
 */
public class GoodsTakeout extends BaseStep {

    private LinkedList<String> liuNames = new LinkedList<>();

    private Map<String, Integer> maps = new HashMap<>();

    public GoodsTakeout(String line) {
        String[] vals = line.split(",");
        for (String val : vals) {
            if (val != null && !"".equals(val.trim())) {
                String[] vas = val.split("_");
                maps.put(vas[0], Integer.valueOf(vas[1]));
            }
        }

    }

    public GoodsTakeout() {
    }

    public void setGoods(String line) {
        maps.clear();
        String[] vals = line.split(",");
        for (String val : vals) {
            if (val != null && !"".equals(val.trim())) {
                String[] vas = val.split("_");
                maps.put(vas[0], Integer.valueOf(vas[1]));
            }
        }

    }

    @Override
    public boolean run() {
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("帮派");
        htmlUtil.linkName("帮派管理");
        htmlUtil.linkName("帮派仓库");
        htmlUtil.linkName("取出物品");
        htmlUtil.linkName("首页");
        htmlUtil.linkName("上页");
        do {
            takeOutPage();
        } while (htmlUtil.linkName("下.页").isSuccess());
        htmlUtil.linkName("返回游戏");
        liuNames.clear();
        return false;
    }


    /**
     * 保存当页物品
     */
    public void takeOutPage() {
        ExistSale existSale = existSale();
        while (existSale.exist) {
            String name = existSale.name;
            takeOutOne(name);
            existSale = existSale();
        }
    }

    /**
     * 保存一个商品
     *
     * @param name 商品名称
     */
    public void takeOutOne(String name) {
        int num = maps.get(name);
        LinkBean res = htmlUtil.linkName(name, getNotNames());
        String clickName = res.getClickName();
        int index = clickName.indexOf("x");
        clickName = clickName.substring(0, index);
        liuNames.add(clickName);
        submitForm(num);
        htmlUtil.linkName("返回物品列表");
        System.out.println("取出物品:" + clickName + "x" + num);
    }

    public void submitForm(int num) {
        Elements forms = htmlUtil.delForms;
        Element form = forms.get(0);
        String action = form.attr("action");
        htmlUtil.linkUrl(action + "&submit=取出&submit=取出&num=" + num);
    }

    /**
     * 检测是否有保存商品存在
     *
     * @return
     */
    public ExistSale existSale() {
        ExistSale existSale = new ExistSale();
        for (String s : maps.keySet()) {
            if (htmlUtil.exitsName(s, getNotNames())) {
                existSale.exist = true;
                existSale.name = s;
                return existSale;
            }
        }
        return existSale;
    }

    public String[] getNotNames() {
        String[] s = {};
        return liuNames.toArray(s);
    }


    private class ExistSale {
        public boolean exist = false;
        public String name = null;
    }

}




