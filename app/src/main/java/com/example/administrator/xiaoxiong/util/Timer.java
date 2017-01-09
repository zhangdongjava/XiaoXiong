package com.example.administrator.xiaoxiong.util;

import android.webkit.WebView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class Timer {
    public static int TIME = 60000;
    public boolean run = false;
    private ExecutorService exec = Executors.newFixedThreadPool(2);
    private WebView webView;

    public Timer(WebView webView) {
        this.webView = webView;
    }

    public void start() {
        run = true;

    }

    private class TimerTheard implements Runnable {

        @Override
        public void run() {
            while (run && !Thread.currentThread().isInterrupted()) {

                //webView.loadUrl(WebBuild.lastUrl);
            }
        }
    }
}







