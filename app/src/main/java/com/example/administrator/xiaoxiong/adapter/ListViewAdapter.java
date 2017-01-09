package com.example.administrator.xiaoxiong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.xiaoxiong.R;
import com.example.administrator.xiaoxiong.bean.Bookmark;
import com.example.administrator.xiaoxiong.ui.activity.BookmarkActivity;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private BookmarkActivity context;                        //运行上下文
    private List<Bookmark> bookmarkList;    //商品信息集合
    private LayoutInflater listContainer;           //视图容器

    public final class ListItemView {                //自定义控件集合
        public TextView name;
        public TextView url;
        public Button openUrl;
        public Button delUrl;
    }


    public ListViewAdapter(BookmarkActivity context, List<Bookmark> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);   //创建视图容器并设置上下文   
        this.bookmarkList = listItems;
    }

    public int getCount() {
        // TODO Auto-generated method stub   
        return bookmarkList.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub   
        return null;
    }

    public long getItemId(int arg0) {
        // TODO Auto-generated method stub   
        return 0;
    }

    /**
     * 打开书签
     *
     * @param checkedID
     */
    private void openUrl(int checkedID) {
        context.openUrl(bookmarkList.get(checkedID).getUrl());
    }

    /**
     * 删除书签
     * @param checkedID
     */
    private void delUrl(int checkedID) {
        bookmarkList.remove(checkedID);
        context.delUrl();
    }


    /**
     * ListView Item设置
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        final int selectID = position;
        //自定义视图   
        ListItemView listItemView = null;
        if (convertView == null) {
            listItemView = new ListItemView();
            //获取list_item布局文件的视图   
            convertView = listContainer.inflate(R.layout.item_bookmark_list, null);
            //获取控件对象   
            listItemView.name = (TextView) convertView.findViewById(R.id.name);
            listItemView.url = (TextView) convertView.findViewById(R.id.url);
            listItemView.openUrl = (Button) convertView.findViewById(R.id.openUrl);
            listItemView.delUrl = (Button) convertView.findViewById(R.id.delUrl);
            //设置控件集到convertView
            convertView.setTag(listItemView);
        } else {
            listItemView = (ListItemView) convertView.getTag();
        }

        listItemView.name.setText(bookmarkList.get(position)
                .getName());
        listItemView.url.setText(bookmarkList.get(position).getUrl());
        //注册按钮点击时间爱你
        listItemView.openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开书签
                openUrl(selectID);
            }
        });
        //注册按钮点击时间爱你
        listItemView.delUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开书签
                delUrl(selectID);
            }
        });
        return convertView;
    }
}  