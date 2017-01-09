package com.example.administrator.xiaoxiong.core;

import com.example.administrator.xiaoxiong.bean.Script;
import com.example.administrator.xiaoxiong.script.BaseStep;
import com.example.administrator.xiaoxiong.script.copy.DangKou;
import com.example.administrator.xiaoxiong.script.copy.DiXiaGuCheng;
import com.example.administrator.xiaoxiong.script.copy.PoSui;
import com.example.administrator.xiaoxiong.script.copy.ZhenList;
import com.example.administrator.xiaoxiong.util.HtmlUtil;

import org.jsoup.Connection;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public class ScriptRun {

    public static LinkedHashSet<BaseStep> curr = new LinkedHashSet<>();
    public static Map<String, BaseStep> cache = Collections.synchronizedMap(new LinkedHashMap<String, BaseStep>());
    public static boolean reload = true;

    public static void run(HtmlUtil htmlUtil) {
        buildCurr();
        for (BaseStep baseStep : curr) {
            baseStep.setHtmlUtil(htmlUtil);
            baseStep.run();
        }
    }

    public static void buildCurr() {
        if (reload) {
            curr.clear();
            curr.addAll(cache.values());
            reload = false;
        }
    }

    public static void add(Script script) {
        cache.put(script.getName(), script.getBaseStep());
        reload = true;
    }

    public static void remove(String name) {
        if (cache.remove(name) != null) {
            reload = true;
        }
    }

}














