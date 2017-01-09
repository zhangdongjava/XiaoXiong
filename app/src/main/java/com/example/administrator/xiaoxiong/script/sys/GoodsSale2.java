package com.example.administrator.xiaoxiong.script.sys;


import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.script.BaseStep;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 柳虫残害清理
 * Created by dell_2 on 2016/10/31.
 */
public class GoodsSale2 extends BaseStep {

    private LinkedList<String> liuNames = new LinkedList<>();

    private Map<String, String> maps = new HashMap<>();

    public GoodsSale2(String line) {
        if (line == null) return;
        String[] vals = line.split(",");
        for (String val : vals) {
            if (val != null && !"".equals(val.trim())) {
                String[] vvs = val.split("_");
                if (vvs.length > 0) {
                    String desc = null;
                    if (vvs.length == 2)
                        desc = vvs[1];
                    maps.put(vvs[0], desc);
                }
            }
        }

    }

    public GoodsSale2() {
    }


    @Override
    public boolean run() {
        if (maps.isEmpty()) {
            return false;
        }
        htmlUtil.linkName("返回游戏");
        htmlUtil.linkName("物品");
        htmlUtil.linkName("首页");
        htmlUtil.linkName("上页");
        do {
            salePage();
        } while (htmlUtil.linkName("下.页").isSuccess());
        htmlUtil.linkName("返回游戏");
        liuNames.clear();
        return false;
    }


    /**
     * 卖出当页物品
     */
    public void salePage() {
        ExistSale existSale = existSale();
        while (existSale.exist) {
            String name = existSale.name;
            saleOne(name, maps.get(name));
            existSale = existSale();
        }
    }

    /**
     * 卖出一个商品
     *
     * @param name 商品名称
     */
    public void saleOne(String name, String desc) {

        LinkBean res = htmlUtil.linkName(name, getNotNames());
        Document doc = htmlUtil.getDocument();
        String content = doc.text();
        if (desc != null && !"".equals(desc.trim())) {
            if (content.contains(desc)) {
                sale();
            } else {
                liuNames.add(res.getClickName());
                htmlUtil.linkName("返回列表");
            }
        } else {
            sale();
        }
    }

    public void sale() {
        htmlUtil.linkName("卖掉", true);
        Element form = htmlUtil.delForms.get(0);
        String action = form.attr("action");
        String num = form.getElementsByTag("input").get(0).val();
        htmlUtil.linkUrl(action + "&num=" + num);
        return;
    }

    /**
     * 检测是否有卖出商品存在
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

    public void putStep(GoodsSale2 step) {
        for (Map.Entry<String, String> entry : step.maps.entrySet()) {
            maps.put(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        maps.clear();
    }

    public void setGoods(String line) {
        if (line == null) return;
        String[] vals = line.split(",");
        for (String val : vals) {
            if (val != null && !"".equals(val.trim())) {
                String[] vvs = val.split("_");
                if (vvs.length > 0) {
                    String desc = null;
                    if (vvs.length == 2)
                        desc = vvs[1];
                    maps.put(vvs[0], desc);
                }
            }
        }

    }
}




