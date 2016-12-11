package com.zhg.junl.treeview.utils;

import com.zhg.junl.treeview.R;
import com.zhg.junl.treeview.utils.annotation.TreeNodeId;
import com.zhg.junl.treeview.utils.annotation.TreeNodeLabel;
import com.zhg.junl.treeview.utils.annotation.TreeNodePid;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junl on 2016/12/11.
 */
public class TreeHelper {

    /**
     * 将用户的数据转换为树形数据
     * @param <T>
     * @return
     */
    public static <T> List<Node> convertDatas2Nodes(List<T> datas) throws IllegalAccessException {
        List<Node> nodes = new ArrayList<>();
        Node node = null;
        int id = -1;
        int pId = -1;
        String label = null;

        for (T t : datas){
            //通过反射+注解的方式 拿去用户自定义bean中的id/pid等字段
            Class clazz = t.getClass();//拿到类名
            Field[] fields = clazz.getDeclaredFields();//拿到所有字段

            for (Field field : fields){
                //说明有TreeNodeId该注解
                if (field.getAnnotation(TreeNodeId.class) != null){
                    field.setAccessible(true);//设置访问权限
                    id = field.getInt(t);
                }
                //说明有TreeNodeId该注解
                if (field.getAnnotation(TreeNodePid.class) != null){
                    field.setAccessible(true);//设置访问权限
                    pId = field.getInt(t);
                }
                //说明有TreeNodeId该注解
                if (field.getAnnotation(TreeNodeLabel.class) != null){
                    field.setAccessible(true);//设置访问权限
                    //当用get方法拿getString时如果没有 则用get
                    label = (String) field.get(t);
                }

                //组装node
                node = new Node(id,pId,label);
                //加入集合 返回
                nodes.add(node);
            }
        }

        /**
         * 设置node节点间的关联关系
         */
        for (int i = 0; i<nodes.size();i++){
            Node n = nodes.get(i);
            for (int j = 0 ;j<nodes.size();j++){
                Node m = nodes.get(j);

                if (m.getpId() == n.getId()){
                    n.getChildren().add(m);
                    m.setParent(n);
                } else if(m.getId() == n.getpId()){
                    m.getChildren().add(n);
                    n.setParent(m);
                }
            }
        }

        for (Node n : nodes){
            setNodeIcon(n);
        }
        return nodes;
    }

    /**
     * 过滤出要可见的节点
     * @param nodes
     * @return
     */
    public static List<Node> filterVisibleNode(List<Node> nodes){
        List<Node> result = new ArrayList<>();

        for (Node node:nodes){
            if (node.isRoot() || node.isExpand()){
                setNodeIcon(node);
                result.add(node);
            }
        }

        return result;
    }

    /**
     * 获得排序后的nodes(从根节点到叶子节点)
     * @param datas
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> List<Node> getSortedNodes(List<T> datas , int defaultExpandLevel) throws IllegalAccessException {

        List<Node> result = new ArrayList<Node>();

        //程序内部自动调用该方法 获得设置关联关系之后的nodes
        List<Node> nodes = convertDatas2Nodes(datas);
        //思路  拿到nodes  在拿到跟node

        List<Node> rootNodes = getRootNodes(nodes);

        for (Node node : rootNodes){

            addNode(result,node,defaultExpandLevel,1);
        }
        return result;
    }

    /**
     * 把一个节点的所有children节点按顺序依次放进去（result）
     * 从出入进去的node开始，把所有的node及子node按顺序依次加进去
     * @param result 处理完的结果
     * @param node 根节点
     * @param defaultExpandLevel 默认展开层级
     * @param currentLevel 当前层级
     */
    private static void addNode(List<Node> result, Node node, int defaultExpandLevel, int currentLevel) {
        //先将根节点加进去
        result.add(node);

        if (defaultExpandLevel >=currentLevel){
            node.setExpand(true);
        }

        if (node.isLeaf())return;

        //递归调用  依次将节点加进去
        for (int i =0; i<node.getChildren().size();i++){
            addNode(result,node.getChildren().get(i),defaultExpandLevel,currentLevel+1);
        }
    }

    /**
     * 从所有节点中获取树的根节点
     * @param nodes
     * @return
     */
    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root = new ArrayList<Node>();

        for (Node node : nodes){
            if (node.isRoot())
                root.add(node);
        }
        return root;
    }

    /**
     * 为Node设置图标
     */
    private static void setNodeIcon(Node n) {
        if (n.getChildren().size()>0 && n.isExpand()){
            //如果该节点有children 并且是expand
            n.setIcon(R.mipmap.tree_down);
        } else if(n.getChildren().size()>0 && !n.isExpand()){
            n.setIcon(R.mipmap.tree_right);
        } else{
            //无图标的状态
            n.setIcon(-1);
        }
    }
}
