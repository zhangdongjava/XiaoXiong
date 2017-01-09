package com.example.administrator.xiaoxiong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xiaoxiong.core.Controller;
import com.example.administrator.xiaoxiong.ui.activity.BookmarkActivity;
import com.example.administrator.xiaoxiong.ui.activity.ScriptActivity;
import com.example.administrator.xiaoxiong.util.HtmlUtil;
import com.example.administrator.xiaoxiong.util.MyWebViewClient;

public class MainActivity extends Activity {

    private WebView webView;
    private MyWebViewClient myWebViewClient;
    private Controller controller;
    private TextView showText;
    private EditText waitTime;
    private EditText fontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        showText = (TextView) this.findViewById(R.id.showText);
        waitTime = (EditText) this.findViewById(R.id.waitTime);
        fontSize = (EditText) this.findViewById(R.id.fontSize);
        initWeb();

    }
//new HtmlUtil(webView)

    public void start(View view) {
        if (controller == null) {
            controller = new Controller(myWebViewClient.lastUrl, this, webView);
        }
        if (controller.runFlag) {
            Toast.makeText(this, "正在运行,无法启动!", Toast.LENGTH_SHORT).show();
        } else {
            controller.start();
        }
    }

    public void stopRun(View view) {
        if (controller != null)
            controller.stop();
    }

    public void setShowText(String text) {
        showText.setText(text);
    }

    public void setTime(View view) {
        try {
            HtmlUtil.TIME_WAIT = Integer.valueOf(waitTime.getText().toString());
            webView.getSettings().setTextZoom(Integer.valueOf(fontSize.getText().toString()));
        } catch (NumberFormatException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void shuQian(View view) {
        if (controller!=null&&controller.runFlag) {
            Toast.makeText(this, "请结束运行再打开书签!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, BookmarkActivity.class);
        startActivityForResult(intent, 0x1);
    }
    public void setScript(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ScriptActivity.class);
        startActivity(intent);
    }

    /**
     * 返回当前界面执行回调方法
     **/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String url = data.getStringExtra("url");
        if (url != null && !"".equals(url)) {
            webView.loadUrl(url);
        }
       // Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
    }

    public void webBack(View view) {
        webView.goBack();
    }

    private void initWeb(){
        webView = (WebView) this.findViewById(R.id.webView);
        myWebViewClient = new MyWebViewClient();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setTextZoom(150);
        webView.setWebViewClient(myWebViewClient);
        final ProgressBar bar = (ProgressBar)findViewById(R.id.myProgressBar);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    bar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == bar.getVisibility()) {
                        bar.setVisibility(View.VISIBLE);
                    }
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });
        webView.loadUrl("http://hero.yytou.com");
    }


}
