package com.example.administrator.xiaoxiong.util;

import android.webkit.WebView;

import com.example.administrator.xiaoxiong.MainActivity;
import com.example.administrator.xiaoxiong.bean.LinkBean;
import com.example.administrator.xiaoxiong.core.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class HtmlUtil {

    private WebView webView;
    private MainActivity activity;
    public String baseUrl;
    public static int TIME_WAIT = 600;
    private String text;
    private Document document;
    private String lastUrl;
    private long lastTime;
    private static int LINE_COUNT = 360;
    public Elements delForms;
    private ValidationKill validationKill;
    public Controller controller;
    private long count;


    public HtmlUtil(WebView webView, MainActivity activity, String url, Controller controller) {
        this.controller = controller;
        setBaseUrl(url);
        this.webView = webView;
        this.activity = activity;
        validationKill = new ValidationKill(this);
        loadUrl(url, 0);
    }

    public LinkBean linkName(String name, boolean like) {
        LinkBean linkBean = getUrl(name, like);
        String url = linkBean.getUrl();
        if (url != null) {
            linkBean.setSuccess(linkUrl(url));
            return linkBean;
        }
        return linkBean;
    }

    /**
     * 获取地址
     *
     * @param name
     * @return
     */
    public LinkBean getUrl(String name, boolean like) {
        String url;
        LinkBean linkBean = new LinkBean();
        Elements elements = document.getElementsByTag("a");
        Element element = getAelement(elements, like, name, linkBean);
        if (element != null) {
            url = element.attr("href");
            linkBean.setUrl(url);
            linkBean.setClickName(element.text());
            return linkBean;
        }

        return linkBean;
    }

    /**
     * 获取模糊name地址但不是notName
     *
     * @param name
     * @return
     */
    private LinkBean getUrl(String name, String... notName) {
        LinkBean linkBean = new LinkBean();
        Elements elements = document.getElementsByTag("a");
        Element element = getAelementNotName(elements, name, linkBean, notName);
        if (element != null) {
            String url = element.attr("href");
            linkBean.setUrl(url);
            linkBean.setClickName(element.text());
        }

        return linkBean;
    }

    private Element getAelementNotName(Elements elements, String name, LinkBean linkBean, String... notName) {
        for (Element element : elements) {
            String text = element.text();
            if (text.contains(name) && !textContainArray(text, notName)) {
                linkBean.setClickName(text);
                return element;
            }
        }
        return null;
    }

    private boolean textContainArray(String text, String... notNames) {
        for (String notName : notNames) {
            if (notName != null) {
                if (text.contains(notName)) {
                    return true;
                }
            }
        }
        return false;
    }


    private Element getAelement(Elements elements, boolean like, String name, LinkBean linkBean) {
        for (Element element : elements) {
            if (!like) {
                if (element.text().equals(name)) {
                    linkBean.setClickName(element.text());
                    return element;
                }
            } else {
                if (element.text().contains(name)) {
                    linkBean.setClickName(element.text());
                    return element;
                }

            }
        }
        return null;
    }

    /**
     * 超链接name是否存在
     *
     * @param name
     * @return
     */
    public boolean exitsName(String name, boolean like) {
        return getUrl(name, like).getUrl() != null;
    }

    /**
     * 模糊name但不是notName的超链接是否存在
     *
     * @param name
     * @param notName
     * @return
     */
    public boolean exitsName(String name, String... notName) {
        return (getUrl(name, notName).getUrl()) != null;
    }

    /**
     * 链接超链接name
     *
     * @param name
     */
    public LinkBean linkName(String name, String... notName) {
        LinkBean linkBean = getUrl(name, notName);
        String url = linkBean.getUrl();
        if (url != null) {
            linkBean.setSuccess(linkUrl(url));
            return linkBean;
        }
        return linkBean;
    }

    /**
     * 模糊name但不是notName的超链接是否存在
     *
     * @param name
     * @return
     */
    public boolean exitsName(String name) {
        return exitsName(name, false);
    }

    /**
     * 链接超链接name
     *
     * @param name
     */
    public LinkBean linkName(String name) {
        return linkName(name, false);
    }

    public boolean linkUrl(String url) {
        return linkUrl(url, 0);
    }

    private boolean loadUrl(String url, int count) {
        if (count > LINE_COUNT) throw new RuntimeException("链接断开!");
        try {
            url = cleckUrl(url);
            document = Jsoup.parse(new URL(url), 2000);
            linkEnd(url);
            showHtml();
        } catch (IOException e) {
            System.out.println(count + 1 + "次尝试链接..." + url);
            loadUrl(url, count + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    private boolean linkUrl(String url, int count) {
        if (count > LINE_COUNT) throw new RuntimeException("链接断开!");
        try {
            await();
            url = cleckUrl(url);
            document = Jsoup.parse(new URL(url), 2000);
            linkEnd(url);
            showHtml();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            System.out.println(count + 1 + "次尝试链接..." + url);
            linkUrl(url, count + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void linkEnd(String url) {

        vailte();
        delForms = document.getElementsByTag("form").remove();
        lastUrl = url;
        text = document.text();
        buildAelements();
        if (text.contains("战斗已经结束")) {
            controller.fightEnd(this);
        }
    }


    public void vailte() {
        try {
            if (exitsName("继续", false)) {
                linkUrl(getUrl("继续", false).getUrl());
            }
            if (exitsName("解除验证", false)) {
                validationKill.kill();
            }
        } finally {
        }
    }

    private void await() throws InterruptedException {
        Thread.sleep(TIME_WAIT);
    }

    public Document getDocument() {
        return document;
    }

    private void buildAelements() {
        Elements elements = document.getElementsByTag("a");
        for (Element element : elements) {
            element.attr("href", buildUrl(element.attr("href")));
        }
    }

    public String cleckUrl(String url) {
        if (!(url.trim().startsWith("http"))) {
            url = baseUrl + url;
        } else {
            setBaseUrl(url);
        }
        return url;
    }

    public String buildUrl(String url) {
        if (!(url.trim().startsWith("http"))) {
            url = baseUrl + url;
        }
        return url;
    }

    public void setBaseUrl(String url) {
        String temp = url.substring(0, url.indexOf("/", 9) + 1);
        if (temp.trim().equals("")) {
            temp = url;
        }
        baseUrl = temp;
    }

    public void showHtml() {

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(lastTime!=0){
                    activity.setShowText((++count)+":"+Long.toString(System.currentTimeMillis() - lastTime));
                }
                lastTime = System.currentTimeMillis();
                webView.loadData(document.html(), "text/html; charset=UTF-8", null);//这种写法可以正确解码
            }
        });

    }

    public String getText() {
        return text;
    }
}
