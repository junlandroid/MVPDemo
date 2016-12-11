package com.zhg.junl.treeview.utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zhg.junl.treeview.utils.Node;
import com.zhg.junl.treeview.utils.TreeHelper;

import java.util.List;

/**
 * Created by Administrator on 2016/12/11.
 */
public abstract class TreeListViewAdapter<T> extends BaseAdapter{

    private Context mContext;
    private List<Node> mAllNodes;
    private List<Node> mVisibleNodes;

    private LayoutInflater mInflater;
    private ListView mTree;

    public interface onTreeNodeClickListener{//1、定义接口
        //将node和position传出去
        void onClick(Node node, int position);
    }
    private onTreeNodeClickListener mListener;//2、申明接口变量

    public void setOnTreeNodeClickListener(onTreeNodeClickListener mListener) {//3、设置回调
        this.mListener = mListener;
    }

    public TreeListViewAdapter(ListView tree,Context context, List<T> datas, int defaultExpandLevel) throws IllegalAccessException {
        //给成员变量赋值
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mAllNodes = TreeHelper.getSortedNodes(datas,defaultExpandLevel);
        mVisibleNodes = TreeHelper.filterVisibleNode(mAllNodes);

        mTree = tree;
        mTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                expandOrCollapse(position);

                if (mListener == null){//4、调用回调方法
                    mListener.onClick(mVisibleNodes.get(position),position);
                }
            }
        });

    }

    /**
     * 点击收缩或展开
     * @param position
     */
    private void expandOrCollapse(int position) {
        Node n = mVisibleNodes.get(position);
        if (n != null){
            if (n.isLeaf())return;;
            n.setExpand(!n.isExpand());
            mVisibleNodes = TreeHelper.filterVisibleNode(mAllNodes);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mAllNodes.size();
    }

    @Override
    public Object getItem(int position) {
        return mAllNodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Node node = mVisibleNodes.get(position);
        convertView = getConvertView(node, position, convertView, parent);

        //给node设置内边距
        convertView.setPadding(node.getLevel(),3,3,3);
        return convertView;
    }

    //公布一个方法  让开发者设置样式
    public abstract View getConvertView(Node node, int position,View convertView , ViewGroup parent);
}
