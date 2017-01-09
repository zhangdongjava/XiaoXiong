package com.example.administrator.xiaoxiong.util;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class MyWebViewClient extends WebViewClient {
    public String lastUrl;

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        lastUrl = url;
        return true;
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

}
