package com.zhg.junl.treeview.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junl on 2016/12/11.
 */
public class Node {

    public Node() {
    }

    public Node(int id, int pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    private int id;
    /**
     * 树的根节点
     */
    private int pId = 0;
    private String name;
    /**
     * 树的层级
     */
    private int level;
    /**
     * 是否是展开
     */
    private boolean isExpand = false;
    /**
     * 图标
     */
    private int icon;

    /**
     * 面向对象的思想 还有父节点和子节点
     */
    private Node parent;
    private List<Node> children = new ArrayList<Node>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }


    /**
     * 是否是根节点
     * @return
     */
    public boolean isRoot(){
        return parent == null;
    }

    /**
     * 判断当前父节点的收缩状态
     * @return
     */
    public boolean isParentExpand(){
        if (parent == null)
            return false;
        return parent.isExpand();
    }

    /**
     * 是否是叶子节点
     * @return
     */
    public boolean isLeaf(){
        return children.size() == 0;
    }

    /**
     * 得到当前节点的层级
     * @return
     */
    public int getLevel() {
        return parent == null ? 0 : parent.getLevel()+1;
    }


    public void setExpand(boolean expand) {
        isExpand = expand;
        if (!isExpand){
            for (Node node : children){
                node.setExpand(false);
            }
        }
    }



}
