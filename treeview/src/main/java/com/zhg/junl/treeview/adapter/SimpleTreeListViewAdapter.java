package com.zhg.junl.treeview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhg.junl.treeview.utils.Node;
import com.zhg.junl.treeview.utils.adapter.TreeListViewAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public class SimpleTreeListViewAdapter<T> extends TreeListViewAdapter<T>{

    public SimpleTreeListViewAdapter(ListView tree, Context context, List<T> datas, int defaultExpandLevel) throws IllegalAccessException {
        super(tree, context, datas, defaultExpandLevel);
    }

    @Override
    public View getConvertView(Node node, int position, View convertView, ViewGroup parent) {
        return null;
    }
}
