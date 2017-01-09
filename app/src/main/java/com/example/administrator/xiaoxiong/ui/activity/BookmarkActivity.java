package com.example.administrator.xiaoxiong.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.administrator.xiaoxiong.R;
import com.example.administrator.xiaoxiong.adapter.ListViewAdapter;
import com.example.administrator.xiaoxiong.bean.Bookmark;
import com.example.administrator.xiaoxiong.util.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 书签管理页面
 */
public class BookmarkActivity extends Activity {

    private static final String FILE_NAME = "bookmark_list";
    private List<Bookmark> bookmarks;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private EditText name;
    private EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_bookmark);
        listView = (ListView) this.findViewById(R.id.bookmarkList);
        url = (EditText) this.findViewById(R.id.url);
        name = (EditText) this.findViewById(R.id.name);
        loadBookmark();
    }

    /**
     * 返回上一个界面
     *
     * @param view
     */
    public void closeDialog(View view) {
        Intent intent = new Intent();
        intent.putExtra("url", "");
        setResult(0x1, intent);
        finish();
    }

    /**
     * 加载书签
     */
    private void loadBookmark() {
        try {
            FileInputStream inputStream = this.openFileInput(FILE_NAME);
            String json = FileUtil.inputToString(inputStream);
            bookmarks = JSON.parseArray(json, Bookmark.class);
        } catch (FileNotFoundException e) {
            showMessage("未找到书签！");
            bookmarks = new ArrayList<>();
        } catch (Exception e) {
            showMessage("读取书签失败!" + e.toString());
            bookmarks = new ArrayList<>();
        }
        listViewAdapter = new ListViewAdapter(this, bookmarks);
        listView.setAdapter(listViewAdapter);
    }

    private void showMessage(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void openUrl(String url) {
        Intent intent = new Intent();
        intent.putExtra("url", url);
        setResult(0x1, intent);
        finish();
    }

    /**
     * 添加书签
     *
     * @param view
     */
    public void addBookmark(View view) {
        String url = this.url.getText().toString();
        String name = this.name.getText().toString();
        if (url == null || "".equals(url)) {
            showMessage("书签地址不能为空!");
            return;
        }else if (name == null || "".equals(name)) {
            showMessage("书签名称不能为空!");
            return;
        }
        Bookmark bookmark = new Bookmark();
        bookmark.setName(name);
        bookmark.setUrl(url);
        bookmarks.add(bookmark);
        buildListAndSave();
    }

    public void delUrl() {
        buildListAndSave();
    }

    private void buildListAndSave(){
        listViewAdapter.notifyDataSetChanged();
        try {
            FileOutputStream out = this.openFileOutput(FILE_NAME, MODE_PRIVATE);
            out.write(JSON.toJSONString(bookmarks).getBytes());
        } catch (Exception e) {
            showMessage("保存书签失败!");
        }
    }
}