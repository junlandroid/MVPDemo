package com.zhg.junl.utils.jsonparseutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 框架类(工具类) - JSON处理类
 * ============================================================================
 * 版权所有 2012-20115 VOS所有，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：
 * ----------------------------------------------------------------------------
 * 官方网站：
 * ----------------------------------------------------------------------------
 * KEY:
 * ============================================================================
 * 注：需要手动添加依赖Gson
 */
public class JsonUtil {

    /**
     * 把java Map 转换成json对象
     * 
     * @param map
     *            把map对象转换成json
     * @return 转换成功的json数据
     */
    public static Object mapToJson(final Map map) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(map);
            return json;
        } catch (final Exception je) {
            je.printStackTrace();
        }
        return null;
    }

    /**
     * 把java List 转换成json对象
     * 
     * @param list
     * @return 转换成功的json数据
     */
    public static String listToJson(final List list) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            return json;
        } catch (final Exception je) {
            je.printStackTrace();
        }
        return null;
    }

    /**
     * 把java bean 转换成json对象
     * 
     * @param bean
     * @return
     */
    public static String beanToJson(final Object bean) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(bean);
            return json;
        } catch (final Exception je) {
            je.printStackTrace();
        }
        return null;
    }

    /**
     * 把json对象 转换成java map
     * 
     * @param map
     *            把map对象转换成json
     * @return 转换成功的json数据
     */
    public static Object jsonToBean(final String data, final Class bean) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(data, bean);
        } catch (final Exception je) {
            je.printStackTrace();
        }
        return null;
    }

    /**
     * 通过传入的json格式的数据，转成该Json数据对应的java类型
     * 
     * @param data
     * @param clazz
     * @return
     */
    public static List jsonToList(final String jsonString, Class clazz) {
        Gson gson = new Gson();
        List list = null;
        // 创建一个JsonParser
        JsonParser parser = new JsonParser();

        // 通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象
        JsonElement el = parser.parse(jsonString);

        // 把JsonElement对象转换成JsonObject
        JsonObject jsonObj = null;
        if (el.isJsonObject()) {
            jsonObj = el.getAsJsonObject();
        }

        // 把JsonElement对象转换成JsonArray
        JsonArray jsonArray = null;
        if (el.isJsonArray()) {
            jsonArray = el.getAsJsonArray();
        }
        if (jsonArray !=null) {
            list = new ArrayList();
            // 遍历JsonArray对象
            Iterator it = jsonArray.iterator();
            while (it.hasNext()) {
                JsonElement e = (JsonElement) it.next();
                // JsonElement转换为JavaBean对象
                list.add(gson.fromJson(e, clazz));
            }
        }
        return list;
    }

    /**
     * 通过传入的json格式的数据，转成该Json数据对应的java类型
     * 
     * @param data
     * @param clazz
     * @return
     */
    public static Object[] jsonToArray(final String jsonString, Class clazz) {
        Gson gson = new Gson();
        Object[] array = null;
        // 创建一个JsonParser
        JsonParser parser = new JsonParser();

        // 通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象
        JsonElement el = parser.parse(jsonString);

        // 把JsonElement对象转换成JsonObject
        JsonObject jsonObj = null;
        if (el.isJsonObject()) {
            jsonObj = el.getAsJsonObject();
        }

        // 把JsonElement对象转换成JsonArray
        JsonArray jsonArray = null;
        if (el.isJsonArray()) {
            jsonArray = el.getAsJsonArray();
        }
        if (jsonArray !=null) {
            array = new Object[jsonArray.size()];
            int i = 0;
            // 遍历JsonArray对象
            Iterator it = jsonArray.iterator();
            while (it.hasNext()) {
                JsonElement e = (JsonElement) it.next();
                // JsonElement转换为JavaBean对象
                array[i] = (gson.fromJson(e, clazz));
                i++;
            }
        }
        return array;
    }
}
