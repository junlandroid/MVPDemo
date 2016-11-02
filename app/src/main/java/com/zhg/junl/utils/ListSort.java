package com.zhg.junl.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort<E>
{

    public static final int DESC = 0;

    /**
     * @param list
     *            要排序的集合
     * @param method
     *            要排序的实体的属性所对应的get方法
     * @param sort
     *            逆序还是正序
     */
    public void sort(List<E> list, final String method, final int sort)
    {
        // 用内部类实现排序
        Collections.sort(list, new Comparator<E>()
        {
            @Override
            public int compare(E a, E b)
            {
                int ret = 0;
                try
                {
                    // 获取m1的方法名
                    Method m1 = a.getClass().getMethod(method, null);
                    // 获取m2的方法名
                    Method m2 = b.getClass().getMethod(method, null);
                    if (DESC == sort)
                    {
                        ret = m2.invoke((b), null).toString().compareTo(m1.invoke((a), null).toString());
                    } else
                    {
                        ret = m1.invoke((a), null).toString().compareTo(m2.invoke((b), null).toString());
                    }
                } catch (NoSuchMethodException ne)
                {
                    ne.printStackTrace();
                } catch (IllegalArgumentException e)
                {
                    e.printStackTrace();
                } catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                } catch (InvocationTargetException e)
                {
                    e.printStackTrace();
                }
                return ret;
            }
        });
    }
}
