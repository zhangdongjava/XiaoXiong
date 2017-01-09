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
import com.example.administrator.xiaoxiong.adapter.ScriptAdapter;
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
public class ScriptActivity extends Activity {

    private static final String FILE_NAME = "bookmark_list";
    private ListView listView;
    private ScriptAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_script);
        listView = (ListView) this.findViewById(R.id.list_item);
        loadListItem();
    }

    /**
     * 返回上一个界面
     *
     * @param view
     */
    public void closeDialog(View view) {
        finish();
    }

    /**
     * 加载书签
     */
    private void loadListItem() {
        adapter = new ScriptAdapter(this);
        listView.setAdapter(adapter);
    }

    private void showMessage(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}