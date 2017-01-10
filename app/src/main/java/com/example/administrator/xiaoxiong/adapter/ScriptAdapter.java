package com.example.administrator.xiaoxiong.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.xiaoxiong.R;
import com.example.administrator.xiaoxiong.bean.Script;
import com.example.administrator.xiaoxiong.core.ScriptRun;
import com.example.administrator.xiaoxiong.script.copy.DangKou;
import com.example.administrator.xiaoxiong.script.copy.DiXiaGuCheng;
import com.example.administrator.xiaoxiong.script.copy.ZhenList;
import com.example.administrator.xiaoxiong.script.copy.normal.BingPoDong;
import com.example.administrator.xiaoxiong.script.copy.normal.HeiFeng;
import com.example.administrator.xiaoxiong.script.copy.normal.ShiRenGu;
import com.example.administrator.xiaoxiong.script.copy.normal.TaiWei;
import com.example.administrator.xiaoxiong.script.copy.normal.XueShan;
import com.example.administrator.xiaoxiong.script.metarial.TianDiReHeHe;
import com.example.administrator.xiaoxiong.script.metarial.TianDiReHeRen;
import com.example.administrator.xiaoxiong.script.yinzi.MangShe;
import com.example.administrator.xiaoxiong.ui.activity.ScriptActivity;

import java.util.ArrayList;
import java.util.List;

public class ScriptAdapter extends BaseAdapter {
    private ScriptActivity context;                        //运行上下文
    private List<Script> scripts;    //商品信息集合
    private LayoutInflater listContainer;           //视图容器

    public final class ListItemView {                //自定义控件集合
        public TextView name;
        public Button addBtn;
        public Button delBtn;
    }


    public ScriptAdapter(ScriptActivity context) {
        this.context = context;
        listContainer = LayoutInflater.from(context);   //创建视图容器并设置上下文
        buildItem();
    }

    private void buildItem() {
        scripts = new ArrayList<>();
        scripts.add(new Script("阵法", new ZhenList()));
        scripts.add(new Script("入梦", new DangKou()));
        scripts.add(new Script("地下古城", new DiXiaGuCheng()));
        scripts.add(new Script("荡寇", new DangKou()));
        scripts.add(new Script("雪山", new XueShan()));
        scripts.add(new Script("冰魄洞", new BingPoDong()));
        scripts.add(new Script("太尉", new TaiWei()));
        scripts.add(new Script("食人谷", new ShiRenGu()));
        scripts.add(new Script("黑风", new HeiFeng()));
        scripts.add(new Script("蟒蛇", new MangShe()));
        scripts.add(new Script("天地人和人", new TianDiReHeRen()));
        scripts.add(new Script("天地人和和", new TianDiReHeHe()));
    }

    public int getCount() {
        // TODO Auto-generated method stub   
        return scripts.size();
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
     * 添加脚本
     *
     * @param checkedID
     */
    private void openUrl(int checkedID) {
        ScriptRun.add(scripts.get(checkedID));
    }

    /**
     * 删除脚本
     *
     * @param checkedID
     */
    private void delUrl(int checkedID) {
        ScriptRun.remove(scripts.get(checkedID).getName());
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
            convertView = listContainer.inflate(R.layout.item_script_list, null);
            //获取控件对象   
            listItemView.name = (TextView) convertView.findViewById(R.id.name);
            listItemView.addBtn = (Button) convertView.findViewById(R.id.addBtn);
            listItemView.delBtn = (Button) convertView.findViewById(R.id.delBtn);
            //设置控件集到convertView
            convertView.setTag(listItemView);
        } else {
            listItemView = (ListItemView) convertView.getTag();
        }

        listItemView.name.setText(scripts.get(position)
                .getName());
        //注册按钮点击时间爱你
        final ListItemView temp = listItemView;
        listItemView.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开书签
                temp.addBtn.setVisibility(View.GONE);
                openUrl(selectID);
                temp.delBtn.setVisibility(View.VISIBLE);
            }
        });
        //注册按钮点击时间爱你
        listItemView.delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开书签
                delUrl(selectID);
                temp.delBtn.setVisibility(View.GONE);
                temp.addBtn.setVisibility(View.VISIBLE);
            }
        });
        if (ScriptRun.cache.containsKey(scripts.get(position).getName())) {
            listItemView.addBtn.setVisibility(View.GONE);
        } else {
            listItemView.delBtn.setVisibility(View.GONE);
        }
        return convertView;
    }
}  