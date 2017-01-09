package com.example.administrator.xiaoxiong.core;

import android.content.Context;
import android.os.PowerManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.administrator.xiaoxiong.MainActivity;
import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.util.HtmlUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class Controller {

    private String url;
    private MainActivity activity;
    private WebView webView;
    public boolean run = false;
    public boolean runFlag = false;
    private ExecutorService exec = Executors.newFixedThreadPool(2);
    private HtmlUtil htmlUtil;
    private Future future;
    private static String[] goods = {"禁军", "御林", "神奇丹药", "高级锻造石", "天书油墨", "魂魄"};
    private boolean inFightEnd = false;
    private PowerManager.WakeLock wakeLock;

    public Controller(String url, MainActivity activity, WebView webView) {
        this.url = url;
        this.activity = activity;
        this.webView = webView;
    }

    public void start() {
        run = true;
        future = exec.submit(new Runnable() {

            @Override
            public void run() {
                showMsg("开始运行!");
                runFlag = true;
                if (htmlUtil == null) {
                    htmlUtil = new HtmlUtil(webView, activity, url, Controller.this);
                }

                acquireWakeLock();
                Controller.this.run();
                releaseWakeLock();
                showMsg("结束运行!");
                runFlag = false;
            }
        });
    }

    public void stop() {
        run = false;
        future.cancel(true);
    }

    private void run() {
        while (run) {
            LinkBean res = htmlUtil.linkName("刷新");
            if (!res.isSuccess()) {
                showMsg("刷新连接不存在，无法挂机!");
            }
            ScriptRun.run(htmlUtil);
        }
    }

    private void showMsg(final String message) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fightEnd(HtmlUtil htmlUtil) {
        if (inFightEnd) return;
        inFightEnd = true;
        try {
            for (String good : goods) {
                htmlUtil.linkName(good, true);
            }
        } finally {
            inFightEnd = false;
        }
    }


    /**
     * 获取电源锁，保持该服务在屏幕熄灭时仍然获取CPU时，保持运行
     */
    private void acquireWakeLock() {
        if (null == wakeLock) {
            PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
            wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK
                    | PowerManager.ON_AFTER_RELEASE, getClass()
                    .getCanonicalName());
            if (null != wakeLock) {
                wakeLock.acquire();
            }
        }
    }

    // 释放设备电源锁
    private void releaseWakeLock() {
        if (null != wakeLock && wakeLock.isHeld()) {
            wakeLock.release();
            wakeLock = null;
        }
    }
}
