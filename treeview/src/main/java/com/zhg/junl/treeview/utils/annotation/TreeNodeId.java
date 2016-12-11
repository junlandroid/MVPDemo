package com.zhg.junl.treeview.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/12/11.
 */
@Target(ElementType.FIELD)//该注解申明在哪些地方（类、属性、方法等）
@Retention(RetentionPolicy.RUNTIME)//该注解什么时候可见(运行时可见)
public @interface TreeNodeId {
}
