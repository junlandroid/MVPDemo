package com.zhg.junl.treeview.bean;

import com.zhg.junl.treeview.utils.annotation.TreeNodeId;
import com.zhg.junl.treeview.utils.annotation.TreeNodeLabel;
import com.zhg.junl.treeview.utils.annotation.TreeNodePid;

/**
 * Created by junl on 2016/12/11.
 *原理  Listview's Item +paddingLeft(level) + expand include
 * 系统中的数据Bean--->Node
 *
 */
public class FileBean {
    @TreeNodeId
    private int id;
    @TreeNodePid
    private int pId;
    @TreeNodeLabel
    private String label;

    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
