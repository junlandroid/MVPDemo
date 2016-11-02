package com.zhg.junl.utils.jsonparseutils;
/**
 * 帮助类
 * @author 顾俊华
 */

public class FromJsonUtils {
	private Class cls;
	private String json;

	/*
	 *说明： 
	 *Class cls 要传入的解析类
	 * 当不需要解析resultData值的时候，就传入Object.class 泛型解析
	 * 反之
	 */
	public FromJsonUtils(Class cls,String json){
		this.cls=cls;
		this.json=json;
	}
	public JsonData fromJson(){
		JsonData result=null;
		try {
			result=JsonData.fromJson(json,cls);
		} catch (Exception e) {
			result=null;
			e.printStackTrace();
		}
		return result;
	}  
}
